package com.ggs.starbug.test.doc;

import org.apache.http.HttpHost;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

/**
 * @Author Starbug
 * @Date 2021/11/23 21:22
 */
public class ESTest_Doc_Delete {

    public static void main(String[] args) throws IOException {
        RestHighLevelClient esClient = new RestHighLevelClient(RestClient.builder(new HttpHost("127.0.0.1", 9200, "http")));

        //插入数据
        DeleteRequest request = new DeleteRequest();
        request.index("user").id("1001");

        //删除数据
        DeleteResponse response = esClient.delete(request, RequestOptions.DEFAULT);
        System.out.println(response.getResult());

        esClient.close();
    }

}
