package com.demozi.spring.boot.data.redis;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

/**
 * @author wujian  2023/7/13 20:35
 */
@Component
public class UserRedisTemplate {


    private final StringRedisTemplate redisTemplate;

    public UserRedisTemplate(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void save(String key, String value) {
        ValueOperations<String, String> ops = this.redisTemplate.opsForValue();
        ops.set(key, value);
    }

    public String get(String key) {
        ValueOperations<String, String> ops = this.redisTemplate.opsForValue();
        return ops.get(key);
    }

}
