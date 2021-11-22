package com.ggs.starbug.test;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

/**
 * @Author Starbug
 * @Date 2021/11/22 22:05
 */
public class ESTest_Client {
    public static void main(String[] args) throws IOException {
        //创建ES客户端
//        TransportClient   7.0.0之后就不推荐使用
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("127.0.0.1", 9200, "http"))
        );

        //关闭连接
        esClient.close();
    }
}
