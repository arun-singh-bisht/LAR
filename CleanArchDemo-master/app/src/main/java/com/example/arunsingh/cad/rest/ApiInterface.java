package com.example.arunsingh.cad.rest;

import com.example.arunsingh.cad.data.model.remote.MovieResponse;
import com.example.arunsingh.cad.data.model.remote.User;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {


    @GET("movie/top_rated")
    Observable<MovieResponse> getTopRatedMovie(@Query("api_key") String apiKey);

    @POST("login/user")
    Observable<User> login(@Query("api_key") String apiKey, @Query("email") String email, @Query("password") String password);

}
