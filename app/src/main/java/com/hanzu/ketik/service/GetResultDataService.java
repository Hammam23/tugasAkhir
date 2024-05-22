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
    Call<InsertResponse> input(@Field("krit1")String krit1,
                               @Field("krit2")String krit2,
                               @Field("krit3")String krit3,
                               @Field("krit4")String krit4,
                               @Field("krit5")String krit5,
                               @Field("krit6")String krit6,
                               @Field("krit7")String krit7,
                               @Field("krit8")String krit8);

    @FormUrlEncoded
    @POST("kriteria")
    Call<InsertResponse> input(@Field("krit1")String krit1,
                               @Field("krit2")String krit2,
                               @Field("krit3")String krit3,
                               @Field("krit4")String krit4);
}
