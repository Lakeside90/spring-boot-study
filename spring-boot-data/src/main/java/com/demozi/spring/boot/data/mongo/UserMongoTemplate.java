package com.demozi.spring.boot.data.mongo;

import com.demozi.spring.boot.data.entity.User;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * MongoTemplate
 *  相对更灵活，使用也更复杂
 *
 * @author wujian  2023/6/20 15:17
 */
@Component
public class UserMongoTemplate {

    private final MongoTemplate mongoTemplate;

    public UserMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public void insert(User user) {
        mongoTemplate.insert(user);
    }

    public List<User> findByName(String name) {
        Query query = Query.query(Criteria.where("name").is(name));
        return mongoTemplate.find(query, User.class);
    }

}
