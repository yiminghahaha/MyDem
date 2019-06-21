package com.example.projectname.net;

import com.example.projectname.utils.AppConstants;
import com.example.projectname.utils.SystemUtil;

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

public class Httputils {
    private  static  Httputils httputils;
    private final Retrofit.Builder builder;

    private Httputils() {
        builder = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create());

    }
    /**
     * 固定模板
     * 创建带缓存的OkhttpClient
     * @return
     */
    private OkHttpClient getOkHttpClient() {
        //设置本地缓存文件
        File cacheFile = new File(AppConstants.PATH_CACHE);
        //设置缓存文件大小
        Cache cache = new Cache(cacheFile, 1024 * 1024 * 50);
        return new OkHttpClient.Builder()
                .cache(cache)
                .addInterceptor(new MyCacheinterceptor())
                .addNetworkInterceptor(new MyCacheinterceptor())
                //设置缓存时间
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                //设置错误重连
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
    public static Httputils getHttputils() {
        if (httputils==null){
            synchronized (Httputils.class){
                if (httputils==null){
                    httputils = new Httputils();
                }
            }
        }
        return httputils;
    }

    public  <T> T  getInstancs(String url,Class<T> tClass){
        return  builder.baseUrl(url).build().create(tClass);
    }

}
