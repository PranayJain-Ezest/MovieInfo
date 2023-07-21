package com.example.movieinfo.repository

import com.example.movieinfo.model.MovieResponse
import com.example.movieinfo.retrofit.MovieApiService
import retrofit2.Response
import javax.inject.Inject

// MovieRepository.kt
class MovieRepository @Inject constructor(private val movieApiService: MovieApiService) {
    suspend fun searchMovies(query: String): Response<MovieResponse> {
        val apiKey = "22ef6f04843e16d522550c36627c46d2"
        return movieApiService.searchMovies(apiKey, query)
    }
}



