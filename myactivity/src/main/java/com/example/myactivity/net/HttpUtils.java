package com.example.myactivity.net;

import com.example.myactivity.utils.AppConstants;
import com.example.myactivity.utils.SystemUtil;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpUtils {
    private  static  HttpUtils httpUtils;
    private final Retrofit.Builder builder;

    private HttpUtils() {
        builder = new Retrofit.Builder()
                .client(getOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create());

    }
    //自己设置ok的拦截器
    private OkHttpClient getOkHttpClient() {
        File file = new File(AppConstants.PATH_CACHE);
        Cache cache = new Cache(file, 1024 * 1024 * 50);
        return new OkHttpClient.Builder()
                .cache(cache)
                .addInterceptor(new MyCacheinterceptor())
                .addNetworkInterceptor(new MyCacheinterceptor())
                .writeTimeout(60,TimeUnit.SECONDS)
                .readTimeout(60,TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build();
    }

    /**
     * 固定模板:网络缓存拦截器y
     */
    private class MyCacheinterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            //这里就是说判读我们的网络条件，要是有网络的话我么就直接获取网络上
            // 面的数据，要是没有网络的话我么就去缓存里面取数据
            if (!SystemUtil.isNetworkConnected()) {
                request = request
                        .newBuilder()
                        .cacheControl(CacheControl.FORCE_CACHE)
                        .build();
            }
            Response originalResponse = chain.proceed(request);
            if (SystemUtil.isNetworkConnected()) {
                int maxAge = 0;
                // 有网络时, 不缓存, 最大保存时长为0
                return originalResponse.newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control", "public ,max-age=" + maxAge)
                        .build();
            } else {
                //s秒
                int maxStale = 60 * 60 * 24;
                return originalResponse.newBuilder()
                        .removeHeader("Pragma")
                        //这里的设置的是我们的没有网络的缓存时间，
                        // 想设置多少就是多少。
                        .header("Cache-Control", "public, only-if-cached," +
                                " max-stale=" + maxStale)
                        .build();
            }
        }
    }

//    private class MyCacheinterceptor implements Interceptor {
//
//        @Override
//        public Response intercept(Chain chain) throws IOException {
//            Request request = chain.request();
//            //判断网络条件  分别判断网络是wifi还是其他网络状态
//            if (!SystemUtil.isNetworkConnected()){
//                request =   request.newBuilder().cacheControl(CacheControl.FORCE_CACHE).build()
//            }
//            Response proceed = chain.proceed(request);
//            if (SystemUtil.isNetworkConnected()){
//                int masAge = 0;
//                return originalResponse.newBuilder()
//                        .removeHeader("Pragma")
//                        .header("Cache-Control", "public ,max-age=" + masAge)
//                        .build();
//            }else {
//                int maxSmal = 60*60*24;
//                return  originalResponse.newBuilder()
//                        .removeHeader("Pragma")
//                        //这里的设置的是我们的没有网络的缓存时间，
//                        // 想设置多少就是多少。
//                        .header("Cache-Control", "public, only-if-cached," +
//                                " max-stale=" + maxSmal)
//                        .build();
//            }
//            return null;
//        }
//    }

    public static HttpUtils getHttpUtils() {
        if (httpUtils==null){
            synchronized (HttpUtils.class){
                if (httpUtils==null){
                    httpUtils = new HttpUtils();
                }
            }
        }
        return httpUtils;
    }

    public  <T> T geturl(String url,Class<T> tClass){
        return builder.baseUrl(url).build().create(tClass);
    }
}
