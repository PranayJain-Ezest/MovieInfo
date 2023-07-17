package com.example.movieinfo.di

import android.app.Application

class MyApplication : Application() {
    private lateinit var movieComponent: MovieComponent

    override fun onCreate() {
        super.onCreate()
        movieComponent = DaggerMovieComponent.builder().build()
    }
}
