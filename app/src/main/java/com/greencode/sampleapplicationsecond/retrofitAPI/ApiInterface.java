package com.greencode.sampleapplicationsecond.retrofitAPI;

import com.greencode.sampleapplicationsecond.response.ServiceResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface ApiInterface {
    @Headers("Content-Type:application/json")
    @GET(MyURL.transactionList)
    Call<ServiceResponse> latestProductList();
}
