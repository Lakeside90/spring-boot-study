package com.demozi.spring.boot.data.mongo;

import com.demozi.spring.boot.data.mongo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
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
        user.setAge(1);
        user.setAddress("安徽合肥");
        Map<String, Object> props = new HashMap<>();
        props.put("role", "admin");
        props.put("point", 19);
        user.setProps(props);
        userMongoTemplate.insert(user);
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

    @Test
    public void testUpdateAgeById() {
        long count = userMongoTemplate.updateAgeById("34fb8c5b-3890-46c3-b5c9-f5f69564a7f6", 23);
        System.out.println(count);
    }

    @Test
    public void testFindByProps() {
//        Map<String, Object> props = new HashMap<>();
//        props.put("role", "admin");
//        props.put("point", 20);
//        List<User> byProps = userMongoTemplate.findByProps(props);

        String sql = "{ \"props.point\": { $gt: 10, $lt: 20 } }";
        List<User> byProps = userMongoTemplate.findByProps(sql);
        System.out.println(byProps);
    }

}