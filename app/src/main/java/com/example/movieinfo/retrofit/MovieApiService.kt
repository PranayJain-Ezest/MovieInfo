package com.example.movieinfo.retrofit

import com.example.movieinfo.model.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface MovieApiService {
    @GET("search/movie")
    suspend fun searchMovies(
        @Query("api_key") apiKey: String,
        @Query("query") query: String
    ): Response<MovieResponse>
}
