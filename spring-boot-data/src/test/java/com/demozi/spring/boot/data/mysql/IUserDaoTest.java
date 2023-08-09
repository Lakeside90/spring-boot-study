package com.demozi.spring.boot.data.mysql;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * @author wujian  2023/8/9 15:41
 */
@SpringBootTest
class IUserDaoTest {

    @Autowired
    private IUserDao userDao;


    @Test
    public void test() {
        System.out.println(userDao.findAll());
    }
}