package com.example.movieinfo.di

import android.app.Application
import dagger.Component

class MyApplication : Application() {
    private lateinit var movieComponent: Component

    override fun onCreate() {
        super.onCreate()
       // movieComponent = DaggerMovieComponent.builder().build()
    }
}
