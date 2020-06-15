package com.example.mvvmrxjavaquickstart.repository;

import com.example.mvvmrxjavaquickstart.data.Example;
import com.example.mvvmrxjavaquickstart.network.AppApiClient;

import java.util.List;

import io.reactivex.Single;

public class GeneralRepository {
    AppApiClient apiClient;

    public GeneralRepository() {
        this.apiClient = new AppApiClient();
    }

    public Single<List<Example>> fetchPosts() {
        return apiClient.getExample();
    }
}
