package com.demozi.spring.boot.data.mongo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Map;

/**
 * entity
 *
 * @author wujian  2023/6/19 19:49
 */
@Data
@Document(collection = "user_info")
public class User implements Serializable {

    @Id
    private String id;

    private int age;

    private String name;

    private String address;

    private Map<String, Object> props;
}
