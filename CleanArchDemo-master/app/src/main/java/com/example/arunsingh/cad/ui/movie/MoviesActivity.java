package com.example.arunsingh.cad.ui.movie;

import android.app.ProgressDialog;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.arunsingh.cad.CustomApplication;
import com.example.arunsingh.cad.R;
import com.example.arunsingh.cad.adapters.MovieListAdapter;
import com.example.arunsingh.cad.data.model.remote.Movie;
import com.example.arunsingh.cad.data.model.remote.MovieResponse;
import com.example.arunsingh.cad.di.component.DaggerMoviesListComponent;
import com.example.arunsingh.cad.di.module.ApplicationContextModule;
import com.example.arunsingh.cad.rest.ApiResponse;
import com.example.arunsingh.cad.ui.BaseActivity;
import com.example.arunsingh.cad.ui.MainActivity;
import com.example.arunsingh.cad.ui.login.LoginActivity;
import com.example.arunsingh.cad.utils.GeneralUtil;
import com.example.arunsingh.cad.utils.ViewModelFactory;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MoviesActivity extends BaseActivity {


    @Inject
    ViewModelFactory viewModelFactory;

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    @Inject
    MovieListAdapter movieListAdapter;
    @Inject
    LinearLayoutManager linearLayoutManager;

    private ProgressDialog progressDialog;

    private String TAG ="MoviesActivity";

    @Override
    protected int layoutRes() {
        return R.layout.activity_moviews;
    }

    @Override
    protected void initialize() {
        //DI
        //DaggerMoviesListComponent.create().inject(this);
        ((CustomApplication)getApplication()).getComponent().inject(this);

        /*DaggerMoviesListComponent
                .builder()
                .applicationContextModule(new ApplicationContextModule(getApplicationContext()))
                .build()
                .inject(this);*/

        progressDialog = GeneralUtil.getProgressDialog(this, "Please wait...");

        initRecycleView();
    }

    private void initRecycleView()
    {
        //step 2: use a linear layout manager
        //LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        //step 3: specify an adapter
        //final MovieListAdapter movieListAdapter = new MovieListAdapter();
        mRecyclerView.setAdapter(movieListAdapter);

        MovieViewModel movieViewModel = ViewModelProviders.of(this,viewModelFactory).get(MovieViewModel.class);
        movieViewModel.getResponse().observe(this, new Observer<ApiResponse>() {
            @Override
            public void onChanged(@Nullable ApiResponse apiResponse) {
                consumeResponse(apiResponse);
            }
        });
        movieViewModel.getTopRatedMovies();

    }

    private void consumeResponse(ApiResponse apiResponse) {

        switch (apiResponse.status) {

            case LOADING:
                progressDialog.show();
                break;

            case SUCCESS:
                progressDialog.dismiss();
                MovieResponse movieResponse = (MovieResponse)apiResponse.data;
                List<Movie> movies = movieResponse.getResults();
                movieListAdapter.setData(movies);
                break;

            case ERROR:
                progressDialog.dismiss();
                Toast.makeText(MoviesActivity.this,"Error in API calling.", Toast.LENGTH_SHORT).show();
                break;

            default:
                break;
        }
    }

}
