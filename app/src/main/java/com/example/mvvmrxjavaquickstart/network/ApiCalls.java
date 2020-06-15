package com.example.mvvmrxjavaquickstart.network;

import com.example.mvvmrxjavaquickstart.data.Example;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface ApiCalls {
    @GET("/posts")
    Single<List<Example>> getPosts();
}
