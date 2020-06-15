package com.example.mvvmrxjavaquickstart.network;

import com.example.mvvmrxjavaquickstart.data.Example;

import java.util.List;

import io.reactivex.Single;

public class AppApiClient {

    public Single<List<Example>> getExample() {
        return RetrofitFactory.serviceProvider.getPosts();
    }
}
