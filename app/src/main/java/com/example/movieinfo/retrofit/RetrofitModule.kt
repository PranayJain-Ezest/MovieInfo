package com.example.movieinfo.retrofit

import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

object RetrofitModule {
    private const val BASE_URL = "https://api.themoviedb.org/3/"

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideMovieApiService(retrofit: Retrofit): MovieApiService {
        return retrofit.create(MovieApiService::class.java)
    }
}
