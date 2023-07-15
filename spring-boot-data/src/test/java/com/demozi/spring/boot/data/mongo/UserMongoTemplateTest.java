package com.demozi.spring.boot.data.mongo;

import com.demozi.spring.boot.data.mongo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.*;
import java.util.concurrent.CountDownLatch;

/**
 * @author wujian  2023/6/20 15:23
 */
@SpringBootTest
class UserMongoTemplateTest {

    @Autowired
    private UserMongoTemplate userMongoTemplate;

    @Test()
    public void testInsert() {
        long start = System.currentTimeMillis();

        int loop = 900;
        CountDownLatch countDownLatch = new CountDownLatch(loop);
        for (int i = 0; i < loop; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    List<User> userList = new ArrayList<>();
                    for (int j = 0; j < 1000; j++) {
                        User user = new User();
                        user.setId(UUID.randomUUID().toString());
                        user.setName(UUID.randomUUID().toString());
                        user.setTimestamp(System.currentTimeMillis());
                        user.setAge(1);
                        user.setAddress("安徽合肥");
                        user.setVersion(Arrays.asList(j));
                        Map<String, Object> props = new HashMap<>();
                        props.put("role", "admin");
                        props.put("point", 19);
                        user.setProps(props);
                        userList.add(user);
                    }
                    userMongoTemplate.insertList(userList);
                    countDownLatch.countDown();
                }
            }).start();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("finish - " + (System.currentTimeMillis() - start));

    }

    @Test
    public void testFindByName() {
        long start = System.currentTimeMillis();
        List<User> byName = userMongoTemplate.findByName("0a3ed8d3-6890-461e-9775-ca9f776b08ae");
        System.out.println(System.currentTimeMillis() - start);
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
        long count = userMongoTemplate.updateAgeById("0a3ed8d3-6890-461e-9775-ca9f776b08ae", 23);
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

    @Test
    public void testCount() {
        System.out.println(userMongoTemplate.count());
    }

    @Test
    public void testDelete() {
        userMongoTemplate.delete();
    }
}