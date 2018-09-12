package com.smart.security;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Iterator;


/**
 * @createdBy:jx
 * @crteat:2018-06-25
 */
@Service("customAccessDecisionManager")
public class CustomAccessDecisionManager implements AccessDecisionManager{
    protected Logger logger = LoggerFactory.getLogger(CustomAccessDecisionManager.class);
    // decide 方法是判定是否拥有权限的决策方法，
    //authentication 是释CustomUserService中循环添加到 GrantedAuthority 对象中的权限信息集合.
    //object 包含客户端发起的请求的requset信息，可转换为 HttpServletRequest request = ((FilterInvocation) object).getHttpRequest();
    //collection是通过访问数据库，根据url找寻到的permission集合。
    // 是否在权限表中，如果在权限表中，则返回给 decide 方法，用来判定用户是否有此权限。如果不在权限表中则放行。
    @Override
    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> collection) throws AccessDeniedException, InsufficientAuthenticationException {
        Object principal = authentication.getPrincipal();
        if(principal instanceof AuthenticatedUser){
            //correct
        }else{
            logger.info("================================user not login, forward to login page!!!!=========================");
        }

        if (collection == null || CollectionUtils.isEmpty(collection)) {
            return;
        }

        Iterator<ConfigAttribute> ite = collection.iterator();

        while (ite.hasNext()) {
            ConfigAttribute ca = ite.next();
            String needPermit = ((SecurityConfig) ca).getAttribute();
            for (GrantedAuthority ga : authentication.getAuthorities()) {
                if (needPermit.trim().equals(ga.getAuthority().trim())) {
                    return;
                }
            }

        }
        throw new AccessDeniedException("no right");


    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
