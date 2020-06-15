package com.example.mvvmrxjavaquickstart.viewmodels;

import androidx.lifecycle.ViewModel;

import com.example.mvvmrxjavaquickstart.data.Example;
import com.example.mvvmrxjavaquickstart.repository.GeneralRepository;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class GeneralViewModel extends ViewModel {
    GeneralRepository repository;

    public GeneralViewModel() {
        repository = new GeneralRepository();
    }

    public List<Example> fetchPosts() {
        final List<Example> postsList = new ArrayList<>();
        repository.fetchPosts().subscribeOn(Schedulers.io()).subscribe(new SingleObserver<List<Example>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onSuccess(List<Example> value) {
                for (Example example : value) {
                    System.out.println("Here is:" + example.getTitle());
                }
            }

            @Override
            public void onError(Throwable e) {

            }
        });

        return postsList;
    }
}
