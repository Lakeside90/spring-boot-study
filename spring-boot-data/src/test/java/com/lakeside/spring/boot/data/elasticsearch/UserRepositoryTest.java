package com.lakeside.spring.boot.data.elasticsearch;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.UUID;

/**
 *
 *
 * @author wujian  2023/6/20 20:09
 */
@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private EsUserRepository repository;

    @Test
    public void testInsert() {
        EsUser user = new EsUser();
        user.setId(UUID.randomUUID().toString());
        user.setName("zhangsan");
        user.setAge(18);
        user.setAddress("安徽合肥");
        EsUser insert = repository.save(user);
        System.out.println(insert);
    }

    @Test
    public void test() {
        List<EsUser> zhangsan = repository.findByName("zhangsan");
        System.out.println(zhangsan);
    }


}