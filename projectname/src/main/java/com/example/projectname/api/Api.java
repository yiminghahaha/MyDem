package com.example.projectname.api;

import com.example.projectname.bean.Gank_bean;
import com.example.projectname.bean.Glidy_item_bean;
import com.example.projectname.bean.NewDay_Hot;
import com.example.projectname.bean.NewDay_bean;
import com.example.projectname.bean.NewDay_colomn;
import com.example.projectname.bean.NodeNaviBean;
import com.example.projectname.bean.WeiChar_Bean;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Api {
    String url = "http://news-at.zhihu.com/api/4/";
    @GET("news/latest")
    Observable<NewDay_bean> getnewday();

    @GET("sections")
    Observable<NewDay_colomn> getcolomn();

    @GET("news/hot")
    Observable<NewDay_Hot> gethot();

    String weichar_url = "http://api.tianapi.com/";
    @GET("wxnew/?key=52b7ec3471ac3bec6846577e79f20e4c&num=10&page=1")
    Observable<WeiChar_Bean> getwichar();

    String glidy_url = "http://gank.io/api/search/query/{搜索字段}/";
    @GET("category/{txt}/count/50/page/1")
    Observable<Glidy_item_bean> getglidy(@Path("txt") String txt);

    String sBaseUrl = "http://gank.io/api/";
    @GET("data/{tech}/{num}/{page}")
    Observable<Gank_bean> getGankData(@Path("tech") String tech, @Path("num") int num, @Path("page") int page);

    String playurl = "https://www.wanandroid.com/";
    @GET("navi/json")
    Observable<NodeNaviBean> getNodeNavi();

}
