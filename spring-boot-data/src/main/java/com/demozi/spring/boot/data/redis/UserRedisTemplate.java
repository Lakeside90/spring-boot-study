package com.demozi.spring.boot.data.redis;

import com.demozi.spring.boot.data.redis.entity.User;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author wujian  2023/7/21 10:21
 */
@Component
public class UserRedisTemplate {

    private final RedisTemplate<String, Object> redisTemplate;

    public UserRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void saveUser(String key, User user) {
        this.redisTemplate.opsForValue().set(key, user);
    }

    public User getUser(String key) {
        return (User) this.redisTemplate.opsForValue().get(key);
    }


}
