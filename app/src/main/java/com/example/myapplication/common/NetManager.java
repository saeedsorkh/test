package com.example.myapplication.common;

import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetManager {


    public Retrofit getRetrofit()
    {
        return  new Retrofit
                .Builder()
                .baseUrl(AppConst.baseUrl)
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
                .client(provideOkHttp())
                .build();

    }

    private OkHttpClient provideOkHttp()
    {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(logging);


        builder.connectTimeout(60, TimeUnit.SECONDS);


        return builder.build();
    }
}
