package com.example.arunsingh.cad.di.module;


import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

import com.example.arunsingh.cad.adapters.MovieListAdapter;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

@Module
public class MoviesListModule {

    @Provides
    public MovieListAdapter provideAdapter()
    {
        return new MovieListAdapter();
    }

   @Provides
    @Inject
    public LinearLayoutManager provideLinearLayoutManager(Context context)
    {
        return new LinearLayoutManager(context);
        //return null;
    }


}
