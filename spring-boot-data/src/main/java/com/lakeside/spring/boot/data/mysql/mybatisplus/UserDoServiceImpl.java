package com.lakeside.spring.boot.data.mysql.mybatisplus;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lakeside.spring.boot.data.mysql.User;
import com.lakeside.spring.boot.data.mysql.mybatisplus.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @author wujian  2023/8/18 11:17
 */
@Service
public class UserDoServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
}
