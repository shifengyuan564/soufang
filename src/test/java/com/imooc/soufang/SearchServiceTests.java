package com.imooc.soufang;

import com.imooc.soufang.entity.form.RentSearch;
import com.imooc.soufang.service.ServiceMultiResult;
import com.imooc.soufang.service.search.HouseIndexKey;
import com.imooc.soufang.service.search.ISearchService;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by 瓦力.
 */
public class SearchServiceTests extends AppTests {

    private static final String ES_INDEX_NAME = "xunwu";
    private static final String ES_INDEX_TYPE = "house";

    @Autowired
    private ISearchService searchService;

    @Autowired
    private TransportClient esClient;

    @Test
    public void testIndex() {
        Long targetHouseId = 15L;
        searchService.index(targetHouseId);
    }

    @Test
    public void testRemove() {
        Long targetHouseId = 15L;
        searchService.remove(targetHouseId);
    }

    @Test
    public void testQuery() {
        RentSearch rentSearch = new RentSearch();
        rentSearch.setCityEnName("bj");
        rentSearch.setStart(0);
        rentSearch.setSize(10);
        rentSearch.setKeywords("国贸");
        ServiceMultiResult<Long> serviceResult = searchService.query(rentSearch);
        Assert.assertTrue(serviceResult.getTotal() > 0);
    }

    /* term精确查询houseId
    GET 172.20.10.11:9200/xunwu/house/_search
    {
      "query" : {
        "term" : {
          "houseId" : {
            "value" : "15",
            "boost" : 1.0
          }
        }
      }
    }
    */

    @Test
    public void termQuery(){

        SearchRequestBuilder requestBuilder = this.esClient.prepareSearch(ES_INDEX_NAME)
                .setTypes(ES_INDEX_TYPE)
                .setQuery(QueryBuilders.termQuery(HouseIndexKey.HOUSE_ID, "15"));

        SearchResponse response = requestBuilder.get();

        List<Map<String, Object>> result = new ArrayList<>();

        for(SearchHit hit : response.getHits()){
            result.add(hit.getSource());
        }
        System.out.println(result);
    }

    /* match模糊匹配
        {
          "query" : {
            "match" : {
              "title" : {
                "query" : "湖光",
                "operator" : "OR",
                "prefix_length" : 0,
                "max_expansions" : 50,
                "fuzzy_transpositions" : true,
                "lenient" : false,
                "zero_terms_query" : "NONE",
                "boost" : 1.0
              }
            }
          }
        }

     */
    @Test
    public void matchQuery(){

        SearchRequestBuilder requestBuilder = this.esClient.prepareSearch("xunwu")
                .setTypes("house")
                .setQuery(QueryBuilders.matchQuery("title","湖光"));

        SearchResponse response = requestBuilder.get();

        List<Map<String, Object>> result = new ArrayList<>();

        for(SearchHit hit : response.getHits()){
            result.add(hit.getSource());
        }
        System.out.println(result);

    }

    /*  多个字段中包含“东直门”的，都会查出来
        {
          "query" : {
            "multi_match" : {
              "query" : "东直门",
              "fields" : [
                "subwayStationName^1.0",
                "title^1.0"
              ],
              "type" : "best_fields",
              "operator" : "OR",
              "slop" : 0,
              "prefix_length" : 0,
              "max_expansions" : 50,
              "lenient" : false,
              "zero_terms_query" : "NONE",
              "boost" : 1.0
            }
          }
        }
    * */
    @Test
    public void multiMatchQuery(){

        SearchRequestBuilder requestBuilder = this.esClient.prepareSearch("xunwu")
                .setTypes("house")
                .setQuery(QueryBuilders.multiMatchQuery("东直门","title","subwayStationName"));


        SearchResponse response = requestBuilder.get();

        List<Map<String, Object>> result = new ArrayList<>();

        for(SearchHit hit : response.getHits()){
            result.add(hit.getSource());
        }
        System.out.println(result);
    }


    @Test
    public void mustQuery(){

    }

    @Test
    public void shouldQuery(){

    }

    @Test
    public void filterQuery(){

    }


}
