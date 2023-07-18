package com.example.movieinfo.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {
    const val BASE_URL = "https://api.themoviedb.org/3/"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val movieApi: MovieApiService by lazy {
        retrofit.create(MovieApiService::class.java)
    }
}
