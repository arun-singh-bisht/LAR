package com.example.arunsingh.cad.ui.login;


import com.example.arunsingh.cad.data.model.remote.MovieResponse;
import com.example.arunsingh.cad.data.model.remote.User;
import com.example.arunsingh.cad.rest.ApiClient;
import com.example.arunsingh.cad.rest.ApiInterface;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

@Singleton
public class Repository {

    ApiInterface apiInterface;

    public Repository(ApiInterface apiInterface) {
        this.apiInterface = apiInterface;
    }

    public Observable<User> login(String email, String password)
    {
        //Get From Remote Server
        //--------------
        //ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Observable<User> responseObservable = apiInterface.login(ApiClient.API_KEY, email, password);
        return responseObservable;
    }

    public Observable<MovieResponse> getTopRatedMovies()
    {
        //Get From Remote Server
        //--------------
        //ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Observable<MovieResponse> responseObservable = apiInterface.getTopRatedMovie(ApiClient.API_KEY);
        return responseObservable;
    }
}
