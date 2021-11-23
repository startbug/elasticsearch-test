package com.ggs.starbug.test.doc;

import com.ggs.starbug.po.User;
import com.google.gson.Gson;
import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

/**
 * @Author Starbug
 * @Date 2021/11/23 21:22
 */
public class ESTest_Doc_BatchInsert {

    public static void main(String[] args) throws IOException {
        RestHighLevelClient esClient = new RestHighLevelClient(RestClient.builder(new HttpHost("127.0.0.1", 9200, "http")));

        //批量插入数据
        BulkRequest request = new BulkRequest();
        Gson gson = new Gson();
        for (int i = 1; i <= 6; i++) {
            User user = User.builder().build().setName("zhangsan" + i).setAge(i * 10).setSex(i % 2 == 0 ? "女" : "男");
            request.add(new IndexRequest().index("user").id("100" + i).source(gson.toJson(user), XContentType.JSON));
        }
        BulkResponse response = esClient.bulk(request, RequestOptions.DEFAULT);

        System.out.println(response.getTook()); //花费的时间
        System.out.println(response.getItems());    //多个操作的响应

        esClient.close();
    }

}
