package com.demozi.spring.boot.data.elasticsearch;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * entity
 *
 * @author wujian  2023/6/19 19:49
 */
@Data
@Document(indexName = "user-info")
public class EsUser implements Serializable {

    @Id
    private String id;

    private int age;

    private String name;

    private String address;

}
