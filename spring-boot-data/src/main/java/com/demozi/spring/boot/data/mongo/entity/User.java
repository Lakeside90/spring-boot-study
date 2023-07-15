package com.demozi.spring.boot.data.mongo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

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
@Document(collection = "user_info")
@CompoundIndexes({
        @CompoundIndex(name = "name_address_timestamp_index", def = "{'name': 1, 'address': 1, 'timestamp': -1}", background = true)
})
public class User implements Serializable {

    @Id
    private String id;

    private int age;

    private String name;

    private String address;

    @Indexed
    private Map<String, Object> props;

    private long timestamp;

    @Indexed
    private List<Integer> version = new ArrayList<>();
}
