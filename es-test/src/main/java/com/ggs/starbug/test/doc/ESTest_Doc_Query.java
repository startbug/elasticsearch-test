package com.ggs.starbug.test.doc;

import com.google.gson.Gson;
import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortOrder;

import java.io.IOException;

/**
 * @Author Starbug
 * @Date 2021/11/23 21:53
 * 查询
 */
public class ESTest_Doc_Query {

    public static void main(String[] args) throws IOException {
        RestHighLevelClient esClient = new RestHighLevelClient(RestClient.builder(new HttpHost("127.0.0.1", 9200, "http")));
        Gson gson = new Gson();

        //1.全部查询
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//        MatchAllQueryBuilder query = QueryBuilders.matchAllQuery();    //查询全部
//        request.source(new SearchSourceBuilder().query(query));
//        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
//        SearchHits hits = response.getHits();
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//        hits.forEach(hit -> {
//            System.out.println(hit.getSourceAsString());
//        });

        //2.条件查询
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//        TermQueryBuilder query = QueryBuilders.termQuery("age", 30);    //把年龄=30的查询出来
//        request.source(new SearchSourceBuilder().query(query));
//        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
//        SearchHits hits = response.getHits();
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//        hits.forEach(hit -> {
//            System.out.println(hit.getSourceAsString());
//        });

        //3.分页查询
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//
//        MatchAllQueryBuilder query = QueryBuilders.matchAllQuery();
//        SearchSourceBuilder builder = new SearchSourceBuilder().query(query);
//        builder.from(2);
//        builder.size(2);
//
//        request.source(builder);
//        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
//        SearchHits hits = response.getHits();
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//        hits.forEach(hit -> {
//            System.out.println(hit.getSourceAsString());
//        });

        //4.排序查询
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//
//        MatchAllQueryBuilder query = QueryBuilders.matchAllQuery();
//        SearchSourceBuilder builder = new SearchSourceBuilder().query(query);
//        builder.sort("age", SortOrder.DESC);
//
//        request.source(builder);
//        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
//        SearchHits hits = response.getHits();
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//        hits.forEach(hit -> {
//            System.out.println(hit.getSourceAsString());
//        });

        //5.过滤字段
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//
//        MatchAllQueryBuilder query = QueryBuilders.matchAllQuery();
//        SearchSourceBuilder builder = new SearchSourceBuilder().query(query);
//        String[] excludes = {"age"};
//        String[] includes = {};
//        builder.fetchSource(includes, excludes);
//
//        request.source(builder);
//        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
//        SearchHits hits = response.getHits();
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//        hits.forEach(hit -> {
//            System.out.println(hit.getSourceAsString());
//        });


        //6.组合查询
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//        BoolQueryBuilder query = QueryBuilders.boolQuery();
////        query.mustNot(QueryBuilders.matchQuery("age", 30)); //不等于30岁
////        query.must(QueryBuilders.matchQuery("sex", "男"));   //性别为男
//
//        query.should(QueryBuilders.matchQuery("age", 30));   //等于30或者40岁
//        query.should(QueryBuilders.matchQuery("age", 40));
//
//
//        SearchSourceBuilder builder = new SearchSourceBuilder().query(query);
//
//        request.source(builder);
//        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
//        SearchHits hits = response.getHits();
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//        hits.forEach(hit -> {
//            System.out.println(hit.getSourceAsString());
//        });

        //7.范围查询
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//        RangeQueryBuilder query = QueryBuilders.rangeQuery("age");
//        query.gte(30);
//        query.lte(50);
//
//        SearchSourceBuilder builder = new SearchSourceBuilder().query(query);
//
//        request.source(builder);
//        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
//        SearchHits hits = response.getHits();
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//        hits.forEach(hit -> {
//            System.out.println(hit.getSourceAsString());
//        });

        //8.模糊查询
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//
//        //Fuzziness.ONE: 模糊匹配相差一个字符的数据
//        FuzzyQueryBuilder query = QueryBuilders.fuzzyQuery("name", "angsan1").fuzziness(Fuzziness.TWO);
//        SearchSourceBuilder builder = new SearchSourceBuilder().query(query);
//
//        request.source(builder);
//        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
//        SearchHits hits = response.getHits();
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//        hits.forEach(hit -> {
//            System.out.println(hit.getSourceAsString());
//        });

        //9.高亮查询
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//
//        TermQueryBuilder query = QueryBuilders.termQuery("name", "zhangsan1");
//        SearchSourceBuilder builder = new SearchSourceBuilder().query(query);
//        HighlightBuilder highlightBuilder = new HighlightBuilder();
//        highlightBuilder.preTags("<font color='red'>"); //指定前后标签
//        highlightBuilder.postTags("</font>");
//        highlightBuilder.field("name");  //对name字段进行高亮显示
//
//        builder.highlighter(highlightBuilder);
//
//        request.source(builder);
//        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
//        SearchHits hits = response.getHits();
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//        hits.forEach(hit -> {
//            System.out.println(hit.getSourceAsString());
//            System.out.println(hit.getHighlightFields());
//        });


        //10.聚合查询
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//        SearchSourceBuilder builder = new SearchSourceBuilder();
//
//        AggregationBuilder aggregationBuilder = AggregationBuilders
//                .max("maxAge")  //给查询的字段起名
//                .field("age");  //需要查询的字段
//        builder.aggregation(aggregationBuilder);
//
//        request.source(builder);
//        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
//        SearchHits hits = response.getHits();
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//        System.out.println(gson.toJson(response.getAggregations().getAsMap()));

        //11.分组查询
        SearchRequest request = new SearchRequest();
        request.indices("user");
        SearchSourceBuilder builder = new SearchSourceBuilder();

        AggregationBuilder aggregationBuilder = AggregationBuilders
                .terms("ageGroup")  //给查询的字段起名
                .field("age");  //需要查询的字段
        builder.aggregation(aggregationBuilder);

        request.source(builder);
        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
        SearchHits hits = response.getHits();
        System.out.println(hits.getTotalHits());
        System.out.println(response.getTook());
        System.out.println(gson.toJson(response.getAggregations().getAsMap()));

        esClient.close();
    }

}
