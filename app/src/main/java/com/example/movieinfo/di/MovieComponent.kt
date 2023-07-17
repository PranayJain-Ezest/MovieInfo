package com.example.movieinfo.di

import com.example.movieinfo.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [MovieModule::class])
interface MovieComponent {
    fun inject(mainActivity: MainActivity)
    // Add other injection methods for any other classes that require injection
}
