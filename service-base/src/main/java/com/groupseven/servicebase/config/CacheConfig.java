package com.groupseven.servicebase.config;

import cn.hutool.cache.CacheUtil;
import cn.hutool.cache.impl.TimedCache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheConfig {
    @Bean
    public TimedCache<String, String> timedCache() {
        return CacheUtil.newTimedCache(1000 * 60);
    }
}
