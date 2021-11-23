package com.ggs.starbug.test.doc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ggs.starbug.po.User;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

/**
 * @Author Starbug
 * @Date 2021/11/23 21:22
 */
public class ESTest_Doc_Insert {

    public static void main(String[] args) throws IOException {
        RestHighLevelClient esClient = new RestHighLevelClient(RestClient.builder(new HttpHost("127.0.0.1", 9200, "http")));

        //插入数据
        IndexRequest request = new IndexRequest();
        request.index("user").id("1001");

        User user = User.builder().build().setAge(30).setName("zhangsan").setSex("男");

        //向ES插入数据,必须将数据转换为JSON格式
        ObjectMapper mapper = new ObjectMapper();
        String userJson = mapper.writeValueAsString(user);
        System.out.println(userJson);
        request.source(userJson, XContentType.JSON);

        IndexResponse response = esClient.index(request, RequestOptions.DEFAULT);
        System.out.println(response.getResult());

        esClient.close();
    }

}
