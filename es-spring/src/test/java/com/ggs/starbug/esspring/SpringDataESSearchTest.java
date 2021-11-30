package com.ggs.starbug.esspring;

import com.ggs.starbug.esspring.es.dao.ProductDao;
import com.ggs.starbug.esspring.po.Product;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

/**
 * @Author Starbug
 * @Date 2021/11/30 22:02
 */
@SpringBootTest
public class SpringDataESSearchTest {

    @Autowired
    private ProductDao productDao;

    /**
     * term查询
     * search调用搜索方法时构建的查询对象
     * term查询会查询分字结果
     */
    @Test
    public void termQuery() {
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("title", "小");
        Iterable<Product> products = productDao.search(termQueryBuilder);
        for (Product product : products) {
            System.out.println(product);
        }
    }

    @Test
    public void termPageQuery() {
        int page = 0;
        int size = 5;
        PageRequest pageRequest = PageRequest.of(page, size);
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("title", "小");
        Iterable<Product> products = productDao.search(termQueryBuilder, pageRequest);
        for (Product product : products) {
            System.out.println(product);
        }
    }

}
