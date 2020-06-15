package com.example.mvvmrxjavaquickstart.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitFactory {
    private static String BASE_URL = "https://jsonplaceholder.typicode.com";

    private static Retrofit networkINSTANCE;
    private static Gson gson;
    private static OkHttpClient okHttpClient;

    static ApiCalls serviceProvider = retrofitServiceCreate().create(ApiCalls.class);

    private static Retrofit retrofitServiceCreate() {
        HttpLoggingInterceptor  interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);


        if (networkINSTANCE == null) {
            if (gson == null) {
                gson = new GsonBuilder().setLenient().create();
            }
            if (okHttpClient == null) {
                okHttpClient = new OkHttpClient.Builder()
                        .addInterceptor(interceptor)
                        .build();
            }
            networkINSTANCE = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(okHttpClient)
                    .build();
        }

        return networkINSTANCE;
    }
}
