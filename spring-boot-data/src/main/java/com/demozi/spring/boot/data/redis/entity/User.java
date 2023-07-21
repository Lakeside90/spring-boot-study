package com.demozi.spring.boot.data.redis.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * entity
 *
 * @author wujian  2023/6/19 19:49
 */
@Data
public class User implements Serializable {

    private int age;

    private String name;

    private Map<String, Object> props;

    private List<Integer> version = new ArrayList<>();
}
