package com.greencode.sampleapplicationsecond.retrofitAPI;

import android.content.Context;

import androidx.annotation.NonNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static Retrofit getClient() {
        String url = MyURL.TEST_SERVER_URL;
        return new Retrofit.Builder()
                .client(getRequestHeader())
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private static OkHttpClient getRequestHeader() {
        return new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @NonNull
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request newRequest = chain.request().newBuilder()
                        .addHeader("Authorization", "OAuth oauth_consumer_key=\"A1AC63F0332A131A78FAC304D007E7D1\",oauth_signature_method=\"PLAINTEXT\",oauth_timestamp=\"1663554615\",oauth_nonce=\"hu54JGoQbFT\",oauth_version=\"1.0\",oauth_signature=\"EC7F18B17A062962C6930A8AE88B16C7%26\"")
                        .build();
                return chain.proceed(newRequest);
            }
        }).build();
    }


}
