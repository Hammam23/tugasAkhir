package com.hanzu.ketik.service;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface GetResultDataService {

    @GET("user")
    Call<ResultList> getResultData();

    @FormUrlEncoded
    @POST("kriteria")
    Call<InsertResponse> input(@Field("krit1")boolean krit1,
                               @Field("krit2")boolean krit2,
                               @Field("krit3")boolean krit3,
                               @Field("krit4")boolean krit4,
                               @Field("krit5")boolean krit5,
                               @Field("krit6")boolean krit6,
                               @Field("krit7")boolean krit7,
                               @Field("krit8")boolean krit8);
}
