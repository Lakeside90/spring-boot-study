package com.lakeside.spring.boot.data.elasticsearch;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 *
 *
 * @author wujian  2023/6/20 17:47
 */
public interface EsUserRepository extends ElasticsearchRepository<EsUser, String> {
    List<EsUser> findByName(String name);

}
