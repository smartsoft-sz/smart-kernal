package com.smart.security;

import com.smart.model.Permission;
import com.smart.model.Resource;
import com.smart.service.PermissionService;
import com.smart.service.ResourceService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @createdBy:jx
 * @crteat:2018-06-25
 */
@Service("customSecurityMetaDataSource")
public class CustomInvocationSecurityMetadataSourceService implements CustomerFilterInvocationSecurityMetadataSource {

    private static Map<AntPathRequestMatcher, Collection<ConfigAttribute>> resourceMap;

    protected String permPrefix = "PERM_";

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private ResourceService resourceService;


    public CustomInvocationSecurityMetadataSourceService() {
    }

    @PostConstruct
    public void init() {
        if(resourceMap == null){
            resourceMap = new HashMap<AntPathRequestMatcher, Collection<ConfigAttribute>>();
        }
        loadResourceDefine();
    }

    /**
     * 加载url与权限（即permission）的mapping的映射关系
     */
    public void loadResourceDefine() {
        List<Permission> permissions = permissionService.findAll();

        for(Permission permission: permissions){
            ConfigAttribute ca = new SecurityConfig(permission.getName());
            List<Resource> resources = resourceService.getResourcesByPermissionId(permission.getId());

            for(Resource res : resources){
                String url = res.getUrl();
                String requestMethod = res.getRequestMethod();
                AntPathRequestMatcher requestMatcher = null;

                if(StringUtils.isNotBlank(requestMethod)){
                    requestMatcher = new AntPathRequestMatcher(url, requestMethod);
                }else{
                    requestMatcher = new AntPathRequestMatcher(url);
                }
                /**
                 * 判断资源文件和权限的对应关系，如果已经存在相关的资源url，
                 * 则要通过该url为key提取出权限集合，将权限增加到权限集合中。
                 * sparta
                 **/
                if (resourceMap.containsKey(requestMatcher)) {
                    Collection<ConfigAttribute> value = resourceMap.get(requestMatcher);
                    value.add(ca);
                    resourceMap.put(requestMatcher, value);
                } else {
                    Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();
                    atts.add(ca);
                    resourceMap.put(requestMatcher, atts);
                }
            }
        }
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        if(resourceMap == null){
            return null;
        }

        Set<ConfigAttribute> allAttributes = new HashSet<ConfigAttribute>();

        for(AntPathRequestMatcher requestMatcher: resourceMap.keySet()){
            allAttributes.addAll(resourceMap.get(requestMatcher));
        }

        return allAttributes;
    }

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) {
        HttpServletRequest request = ((FilterInvocation) object).getRequest();
        return getAttributes(request);
    }

    @Override
    public Collection<ConfigAttribute> getAttributes(HttpServletRequest request) {
        if(resourceMap == null || resourceMap.isEmpty()){
            return null;
        }
        Set<ConfigAttribute> list = new HashSet<>();
        for(AntPathRequestMatcher requestMatcher: resourceMap.keySet()){
            if((requestMatcher).matches(request)){
                list.addAll(resourceMap.get(requestMatcher));
            }
        }
        if (CollectionUtils.isEmpty(list)){
            return null;
        }
        return list;
    }

    @Override
    public boolean supports(Class<?> arg0) {
        return true;
    }
}
