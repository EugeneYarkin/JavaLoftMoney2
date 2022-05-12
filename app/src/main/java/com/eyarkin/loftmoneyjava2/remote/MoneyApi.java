package com.eyarkin.loftmoneyjava2.remote;

import com.eyarkin.loftmoneyjava2.remote.models.money.MoneyItemResponse;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface MoneyApi {

    @GET("./items")
    Single<List<MoneyItemResponse>> getItems(@Query("type") String type,
                                            @Query("auth-token") String token);

    @POST("./items/add")
    @FormUrlEncoded
    Completable addItem(@Field("price") int price,
                        @Field("name") String name,
                        @Field("type") String type,
                        @Field("auth-token") String token);

}
