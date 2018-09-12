package com.smart.security;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

public interface CustomerFilterInvocationSecurityMetadataSource extends FilterInvocationSecurityMetadataSource {

    public Collection<ConfigAttribute> getAttributes(HttpServletRequest request);
}
