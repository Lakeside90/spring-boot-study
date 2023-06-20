package com.demozi.spring.boot.data.mongo;

import com.demozi.spring.boot.data.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.UUID;

/**
 *
 * @author wujian  2023/6/20 15:23
 */
@SpringBootTest
class UserMongoTemplateTest {

    @Autowired
    private UserMongoTemplate userMongoTemplate;

    @Test
    public void testInsert() {
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setName("zhangsan");
        user.setAge(18);
        user.setAddress("安徽合肥");
        userMongoTemplate.insert(user);
    }

    @Test
    public void testFindByName() {
        List<User> byName = userMongoTemplate.findByName("zhangsan");
        System.out.println(byName);
    }

}