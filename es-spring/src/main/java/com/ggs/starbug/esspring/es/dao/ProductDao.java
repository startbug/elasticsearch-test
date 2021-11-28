package com.ggs.starbug.esspring.es.dao;

import com.ggs.starbug.esspring.po.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author Starbug
 * @Date 2021/11/28 21:15
 */
@Repository
public interface ProductDao extends ElasticsearchRepository<Product, Long> {
}
