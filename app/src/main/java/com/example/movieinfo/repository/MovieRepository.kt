package com.example.movieinfo.repository

import com.example.movieinfo.retrofit.MovieApiService
import com.example.movieinfo.model.Movie


class MovieRepository(private val movieApiService: MovieApiService) {
    suspend fun searchMovies(query: String): List<Movie> {
        val apiKey = "22ef6f04843e16d522550c36627c46d2" // Replace with your actual API key
        val response = movieApiService.searchMovies(query, apiKey)
        return if (response.isSuccessful) {
            response.body()?.results ?: emptyList()
        } else {
            emptyList()
        }
    }
}
