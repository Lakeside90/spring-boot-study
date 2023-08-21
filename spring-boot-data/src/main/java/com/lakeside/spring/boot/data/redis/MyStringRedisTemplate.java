package com.lakeside.spring.boot.data.redis;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author wujian  2023/7/13 20:35
 */
@Component
public class MyStringRedisTemplate {

    private final StringRedisTemplate redisTemplate;

    public MyStringRedisTemplate(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void save(String key, String value) {
        ValueOperations<String, String> ops = this.redisTemplate.opsForValue();
        ops.set(key, value);
    }

    public void saveWithExpire(String key, String value, long expireMs) {
        ValueOperations<String, String> ops = this.redisTemplate.opsForValue();
        ops.set(key, value, expireMs, TimeUnit.MILLISECONDS);
    }

    public String get(String key) {
        ValueOperations<String, String> ops = this.redisTemplate.opsForValue();
        return ops.get(key);
    }

    public void delete(String key) {
        this.redisTemplate.delete(key);
    }

    public void saveHashMap(String key, Map<String, ?> value) {
        this.redisTemplate.opsForHash().putAll(key, value);
    }

    public Map<Object, Object> getHashMap(String key) {
        return this.redisTemplate.opsForHash().entries(key);
    }

    public void expire(String key, long expireMs) {
        this.redisTemplate.expire(key, expireMs, TimeUnit.MILLISECONDS);
    }

    /**
     * 过期时间还剩多少, 已过期则返回-2
     */
    public Long getExpire(String key) {
        return this.redisTemplate.getExpire(key, TimeUnit.MILLISECONDS);
    }


}
