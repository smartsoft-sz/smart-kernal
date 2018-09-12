package com.smart.security;

import com.smart.model.Permission;
import com.smart.model.User;
import com.smart.service.PermissionService;
import com.smart.service.UserService;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Authenticate a user from the database.
 */
@Component("userDetailsService")
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final Logger log = LoggerFactory.getLogger(UserDetailsService.class);

    @Autowired
    private UserService userService;

    @Autowired
    private PermissionService permissionService;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(final String loginName) {
        log.debug(" ===> Authenticating {}", loginName);
        String lowercaseLogin = loginName.toLowerCase();
        User user = userService.findByLoginName(loginName);
        if(user != null){
            List<GrantedAuthority> authorities  = new ArrayList<>();
            List<Permission> permissions = permissionService.findByUserId(user.getId());
            if (CollectionUtils.isEmpty(permissions)){
                authorities.add(new SimpleGrantedAuthority("no Authentication"));
            }else {
                permissions.stream().map(item -> authorities.add(new SimpleGrantedAuthority(item.getName())))
                        .collect(Collectors.toList());
            }
            AuthenticatedUser authenticatedUser =
                    new AuthenticatedUser(lowercaseLogin, user.getPassword(), authorities);
            authenticatedUser.setUserId(user.getId());
            return authenticatedUser;
        }else{
            throw new UsernameNotFoundException("User " + lowercaseLogin + " was not found in the " +
                    "database");
        }
    }
}
