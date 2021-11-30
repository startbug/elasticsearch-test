package com.ggs.starbug.esspring;

import com.ggs.starbug.esspring.es.dao.ProductDao;
import com.ggs.starbug.esspring.po.Product;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.*;

/**
 * @Author Starbug
 * @Date 2021/11/30 21:41
 */
@SpringBootTest
public class SpringDataESProductDaoTest {

    @Autowired
    private ProductDao productDao;

    /**
     * 新增
     */
    @Test
    public void save() {
        Product product = Product.of(2L, "华为手机", "手机", 2999.0, "http://www.starbug.vip/hw.jpg");
        productDao.save(product);
    }

    /**
     * 修改
     */
    @Test
    public void update() {
        Product product = Product.of(2L, "小米手机", "手机", 5666.0, "http://www.starbug.vip/hw.jpg");
        productDao.save(product);
    }

    /**
     * 根据id查询
     */
    @Test
    public void findById() {
        Optional<Product> productOptional = productDao.findById(2L);
        System.out.println(productOptional.get());
    }

    /**
     * 查询所有
     */
    @Test
    public void findAll() {
        Iterable<Product> iterator = productDao.findAll();
        for (Product product : iterator) {
            System.out.println(product);
        }
    }

    /**
     * 查询所有
     */
    @Test
    public void delete() {
        Product product = new Product().setId(2L);
        productDao.delete(product);
    }


    /**
     * 批量新增
     */
    @Test
    public void saveAll() {
        List<Product> list = Lists.newArrayList();
        for (long i = 0; i < 10; i++) {
            Product product = Product.of(i, "小米手机", "手机", 5666.0 + i, "http://www.starbug.vip/hw.jpg");
            list.add(product);
        }
        productDao.saveAll(list);
    }

    /**
     * 分页查询
     */
    @Test
    public void findByPageable() {
        //设置排序(排序方式:正序还是倒叙,排序ID)
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        int form = 0;
        int size = 5;
        //设置分页
        PageRequest pageRequest = PageRequest.of(form, size);
        Page<Product> productPage = productDao.findAll(pageRequest);
        for (Product product : productPage.getContent()) {
            System.out.println(product);
        }
    }


}
