package com.example.resource.dog.infra;

import com.example.resource.dog.service.IDogService;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitConfig {

    private static final String CONTEXT_API = "https://dog.ceo/api/";
    private final Retrofit retrofit;

    public RetrofitConfig() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.addInterceptor(interceptor);

        retrofit = new Retrofit.Builder().baseUrl(CONTEXT_API)
                .addConverterFactory(JacksonConverterFactory.create())
                .client(client.build())
                .build();
    }

    public IDogService getDogService(){
        return this.retrofit.create(IDogService.class);
    }

}
