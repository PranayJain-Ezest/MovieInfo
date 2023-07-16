package com.example.movieinfo.repository

import com.example.movieinfo.api.MovieApiService
import com.example.movieinfo.model.Movie

class MovieRepository(private val movieApiService: MovieApiService) {
    suspend fun searchMovies(query: String): List<Movie> {
        val apiKey = "YOUR_API_KEY_HERE" // Replace with your actual API key
        val response = movieApiService.searchMovies(query, apiKey)
        return if (response.isSuccessful) {
            response.body()?.results ?: emptyList()
        } else {
            emptyList()
        }
    }
}
