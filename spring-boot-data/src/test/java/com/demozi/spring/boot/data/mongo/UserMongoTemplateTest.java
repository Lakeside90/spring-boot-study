package com.demozi.spring.boot.data.mongo;

import com.demozi.spring.boot.data.mongo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

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
        for (int i = 0; i < 20; i++) {
            User user = new User();
            user.setId(UUID.randomUUID().toString());
            user.setName("zhangsan");
            user.setAge(i);
            user.setAddress("安徽合肥");
            userMongoTemplate.insert(user);
        }
    }

    @Test
    public void testFindByName() {
        List<User> byName = userMongoTemplate.findByName("zhangsan");
        System.out.println(byName);
    }

    @Test
    public void testFindByNameWithSort() {
        List<User> byName = userMongoTemplate.findByNameWithSort("zhangsan", Sort.by(Sort.Direction.DESC, "age"));
        System.out.println(byName);
    }

    @Test
    public void testFindByNameWithPage() {
        List<User> byName = userMongoTemplate.findByNameWithPage("zhangsan", PageRequest.of(0, 10));
        System.out.println(byName);
    }
}