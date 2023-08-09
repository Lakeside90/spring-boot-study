package com.demozi.spring.boot.data.mysql;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author wujian  2023/8/9 14:29
 */
@Repository
public interface IUserDao extends IBaseDao<User, Long> {

   List<User> findByUserName(String userName);


}
