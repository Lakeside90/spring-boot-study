package com.lakeside.spring.boot.data.redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 *
 * @author wujian  2023/7/13 20:54
 */
@SpringBootTest
class StringRedisTemplateTest {

    @Autowired
    private MyStringRedisTemplate redisTemplate;

    @Test
    public void test() {
        String key = "name";
        String value = "zhangsan";
        redisTemplate.save(key, value);

        assertEquals(value, redisTemplate.get(key));

        System.out.println(redisTemplate.get(key));

        redisTemplate.delete(key);
        assertNull(redisTemplate.get(key));
    }

    @Test
    public void testHashMap() {
        String key = "map";
        Map<String, String> value = new HashMap<>();
        value.put("age", "20");
        value.put("name", "zhangsan");
        redisTemplate.saveHashMap(key, value);

        Map<Object, Object> hashMap = redisTemplate.getHashMap(key);
        hashMap.forEach((k,v) -> {
            System.out.printf("key: " + k + "----value: " + v);
        });
    }

    @Test
    public void testSaveWithExpire() throws InterruptedException {
        String key = "expire";
        String value = "33";
        redisTemplate.saveWithExpire(key, value, 3000);
        System.out.println(redisTemplate.get(key));

        TimeUnit.SECONDS.sleep(4);
        System.out.println(redisTemplate.get(key));
        assertNull(redisTemplate.get(key));
    }

    @Test
    public void testExpire() throws InterruptedException {
        String key = "expire";
        String value = "33";

        redisTemplate.save(key, value);

        redisTemplate.expire(key, 3000);

        System.out.println(redisTemplate.getExpire(key));

        TimeUnit.SECONDS.sleep(5);

        System.out.println(redisTemplate.getExpire(key));

        System.out.println(redisTemplate.get(key));
        assertNull(redisTemplate.get(key));
    }

}