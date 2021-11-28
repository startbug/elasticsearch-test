package com.ggs.starbug.esspring.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;

/**
 * @Author Starbug
 * @Date 2021/11/28 21:07
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "product", shards = 3, replicas = 1)
public class Product {
    @Id
    private String id;  //商品的唯一标识
    @Field(type = FieldType.Text)
    private String title;   //商品名称
    @Field(type = FieldType.Keyword)
    private String category;    //分类名称
    @Field(type = FieldType.Double)
    private Double price;   //商品价格
    @Field(type = FieldType.Keyword, index = false)
    private String images;  //图片地址

}
