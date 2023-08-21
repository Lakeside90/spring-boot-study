package com.lakeside.spring.boot.data.mongo;

import com.lakeside.spring.boot.data.mongo.entity.User;
import com.mongodb.client.result.UpdateResult;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * MongoTemplate
 * 相对更灵活，使用也更复杂
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

    public void insertList(List<User> users) {
        mongoTemplate.insertAll(users);
    }

    public List<User> findByName(String name) {
        Query query = Query.query(Criteria.where("name").is(name));
        return mongoTemplate.find(query, User.class);
    }

    public List<User> findByNameWithSort(String name, Sort sort) {
        Query query = Query.query(Criteria.where("name").is(name)).with(sort);
        return mongoTemplate.find(query, User.class);
    }

    public List<User> findByNameWithPage(String name, PageRequest pageRequest) {
        Query query = Query.query(Criteria.where("name").is(name)).with(pageRequest);
        return mongoTemplate.find(query, User.class);
    }

    public long updateAgeById(String id, int age) {
        Query query = Query.query(Criteria.where("_id").is(id));
        Update update = Update.update("age", age);
        UpdateResult updateResult = mongoTemplate.updateFirst(query, update, User.class);
        return updateResult.getModifiedCount();
    }

    public List<User> findByProps(Map<String, Object> props) {
        Query query = new Query();
        props.forEach((key, value) -> {
            Criteria criteria = Criteria.where("props." + key).is(value);
            query.addCriteria(criteria);

        });
        return mongoTemplate.find(query, User.class);
    }

    public List<User> findByProps(String sql) {
        BasicQuery query = new BasicQuery(sql);
        return mongoTemplate.find(query, User.class);
    }

    public long count() {
       return mongoTemplate.count(Query.query(Criteria.where("age").is(1)), User.class);
    }

    public void delete() {
        mongoTemplate.remove(Query.query(Criteria.where("age").is(1)), User.class);
    }
}
