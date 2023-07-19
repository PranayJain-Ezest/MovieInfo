package com.example.movieinfo.repository

import com.example.movieinfo.retrofit.MovieApiService
import com.example.movieinfo.model.Movie
import com.example.movieinfo.model.MovieResponse

import retrofit2.Response
import javax.inject.Inject

// MovieRepository.kt
class MovieRepository @Inject constructor(private val movieApiService: MovieApiService) {
    suspend fun searchMovies(query: String): Response<MovieResponse> {
        val apiKey = "22ef6f04843e16d522550c36627c46d2" // Replace with your actual API key from themoviedb.org
        return movieApiService.searchMovies(apiKey, query)
    }
}



