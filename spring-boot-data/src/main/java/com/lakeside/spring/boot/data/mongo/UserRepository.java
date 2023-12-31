package com.lakeside.spring.boot.data.mongo;

import com.lakeside.spring.boot.data.mongo.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * <p>
 * insert: 插入，主键一致则无法插入
 * save：保存，主键不存在则插入，存在则更新
 * <p>
 * 查询方法关键字列表
 * https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/#mongo.repositories
 * </p>
 *
 * @author wujian  2023/6/19 20:03
 */
public interface UserRepository extends MongoRepository<User, String> {

    List<User> findByName(String name);

    Page<User> findByName(String name, Pageable pageable);

    List<User> findByAgeLessThan(int age);

    List<User> findByName(String name, Sort sort);

}
