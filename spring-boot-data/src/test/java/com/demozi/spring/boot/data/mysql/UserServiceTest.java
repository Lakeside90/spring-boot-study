package com.demozi.spring.boot.data.mysql;

import com.demozi.spring.boot.data.mysql.mybatisplus.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * TODO
 *
 * @author wujian  2023/8/18 11:23
 */
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private IUserService userService;

    @Test
    public void test() {
        System.out.println(userService.list());
    }
}
