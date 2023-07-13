package com.demozi.spring.boot.data.redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author wujian  2023/7/13 20:54
 */
@SpringBootTest
class UserRedisTemplateTest {

    @Autowired
    private UserRedisTemplate redisTemplate;

    @Test
    public void test() {
        String key = "name";
        String value = "zhangsan";
        redisTemplate.save(key, value);

        assertEquals(value, redisTemplate.get(key));

        System.out.println(redisTemplate.get(key));
    }

}