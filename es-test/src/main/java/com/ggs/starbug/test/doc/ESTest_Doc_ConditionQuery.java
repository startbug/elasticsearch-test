package com.ggs.starbug.test.doc;

import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.io.IOException;

/**
 * @Author Starbug
 * @Date 2021/11/23 21:53
 * 条件查询
 */
public class ESTest_Doc_ConditionQuery {

    public static void main(String[] args) throws IOException {
        RestHighLevelClient esClient = new RestHighLevelClient(RestClient.builder(new HttpHost("127.0.0.1", 9200, "http")));

        //查询数据
        SearchRequest request = new SearchRequest();
        request.indices("user");
        TermQueryBuilder query1 = QueryBuilders.termQuery("age", 30);    //把年龄=30的查询出来
        request.source(new SearchSourceBuilder().query(query1));

        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);

        SearchHits hits = response.getHits();
        System.out.println(hits.getTotalHits());
        System.out.println(response.getTook());

        hits.forEach(hit -> {
            System.out.println(hit.getSourceAsString());
        });

        esClient.close();
    }

}
