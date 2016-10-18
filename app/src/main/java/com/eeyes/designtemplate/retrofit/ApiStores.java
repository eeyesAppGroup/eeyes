package com.eeyes.designtemplate.retrofit;
import com.eeyes.designtemplate.bean.AcItem;
import com.eeyes.designtemplate.bean.TestData;
import com.eeyes.designtemplate.bean.TestData1;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * 所有网络访问的接口都写在这里，方便统一管理
 * Created by guolei on 2016/7/30.
 */
public interface ApiStores {



    //获取最新的数据，只用于测试
    @GET("api/4/news/latest")
    Observable<TestData> getLatest();

    //获取历史数据，用于加载更多
    @GET("api/4/news/before/{date}")
    Observable<TestData> getMore(@Path("date") String date);

    @GET("api/4/news/{id}")
    Observable<TestData1> cache(@Path("id") String id);

    @GET("index.php/Api/getAcInfo")
    Observable<List<AcItem>> getLatestAllAcItemsByPage(@Query("limit") int limit, @Query("page") int page);

    @GET("index.php/Api/getAcInfo")
    Observable<List<AcItem>> getLatestAcItemsByTypeAndPage(@Query("limit") int limit, @Query("typeid") String typeid, @Query("page") int page);


}
