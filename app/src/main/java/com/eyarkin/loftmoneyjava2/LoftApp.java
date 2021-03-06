package com.eyarkin.loftmoneyjava2;

import android.app.Application;

import com.eyarkin.loftmoneyjava2.remote.AuthApi;
import com.eyarkin.loftmoneyjava2.remote.MoneyApi;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoftApp extends Application {

    public MoneyApi moneyApi;
    public AuthApi authApi;

    public static String AUTH_KEY = "authKey";

    @Override
    public void onCreate() {
        super.onCreate();

        configureRetrofit();

    }

    private void configureRetrofit() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://loftschool.com/android-api/basic/v1/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        moneyApi = retrofit.create(MoneyApi.class);
        authApi = retrofit.create(AuthApi.class);
    }
}
