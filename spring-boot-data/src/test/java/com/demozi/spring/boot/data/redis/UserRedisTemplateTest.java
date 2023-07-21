package com.demozi.spring.boot.data.redis;

import com.demozi.spring.boot.data.redis.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wujian  2023/7/21 10:32
 */
@SpringBootTest
public class UserRedisTemplateTest {

    @Autowired
    private UserRedisTemplate redisTemplate;

    @Test
    public void save() {
        User user = new User();
        user.setAge(20);
        user.setName("zhangsan");
        Map<String, Object> props = new HashMap<>();
        props.put("int", 11);
        props.put("string", "txt");
        user.setProps(props);
        user.setVersion(Arrays.asList(1, 9));
        redisTemplate.saveUser("zs", user);

        System.out.println(redisTemplate.getUser("zs"));
    }

}