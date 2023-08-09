package com.demozi.spring.boot.data.mysql;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDateTime;
import java.util.List;

/**
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

    @Test
    public void testInsert() {
        User user = new User();
        user.setUserName("lisi");
        user.setPassword("dddd");
        user.setPhoneNumber(44444444);
        user.setCreateTime(LocalDateTime.now());
        userDao.save(user);
        List<User> byId = userDao.findByUserName("lisi");
        Assertions.assertFalse(byId.isEmpty());
    }

    @Test
    public void testFind() {
        List<User> one = userDao.findAll(new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return query.where(criteriaBuilder.equal(root.get("userName"), "lisi")).getRestriction();
            }
        });

        Assertions.assertFalse(one.isEmpty());
    }
}