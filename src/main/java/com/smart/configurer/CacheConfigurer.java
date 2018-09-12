package com.smart.configurer;

import net.sf.ehcache.CacheManager;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

/**
 * Cache 配置
 */
@Configuration
public class CacheConfigurer {

    @Bean
    public CacheManager ehcacheManager() {
        EhCacheManagerFactoryBean factory = new EhCacheManagerFactoryBean();
        factory.setConfigLocation(new ClassPathResource("ehcache.xml"));
        factory.afterPropertiesSet();
        return factory.getObject();
    }

    @Bean
    public EhCacheCacheManager cacheManager(CacheManager ehcacheManager) {
        EhCacheCacheManager manager = new EhCacheCacheManager();
        manager.setCacheManager(ehcacheManager);
        return manager;
    }

}

