package com.demozi.spring.boot.data.mongo;

import com.demozi.spring.boot.data.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * test
 *
 * @author wujian  2023/6/19 20:14
 */
@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testInsert() {
        User user = new User();
        user.setId("123");
        user.setName("zhangsan");
        user.setAge(18);
        user.setAddress("安徽合肥");
        User insert = userRepository.insert(user);
        System.out.println(insert);
    }

    @Test
    public void testSave() {
        User user = new User();
        user.setId("1234");
        user.setName("zhangsan");
        user.setAge(18);
        user.setAddress("安徽合肥");
        User insert = userRepository.save(user);
        System.out.println(insert);
    }

    @Test
    public void testSaveAll() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setId(UUID.randomUUID().toString());
            user.setAge(20);
            user.setName("zhangsan-" + i);
        }
        userRepository.saveAll(users);
    }

    @Test
    public void testFindAll() {
        List<User> users = userRepository.findAll();
        System.out.println(users);
    }

    @Test
    public void testFindAllWithPage() {
        PageRequest pageRequest = PageRequest.of(0, 10, Sort.by("age"));
        Page<User> all = userRepository.findAll(pageRequest);
        System.out.println(all.getContent());
    }

    @Test
    public void testFindByNameWithPage() {
        PageRequest pageRequest = PageRequest.of(0, 2, Sort.by("age"));
        Page<User> all = userRepository.findByName("zhangsan", pageRequest);
        System.out.println(all.getContent());
    }

    @Test
    public void testFindByAge() {
        List<User> byAge = userRepository.findByAgeLessThan(20);
        System.out.println(byAge);
    }


}