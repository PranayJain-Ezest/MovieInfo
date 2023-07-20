package com.example.movieinfo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieinfo.retrofit.MovieApiService
import com.example.movieinfo.model.Movie
import com.example.movieinfo.repository.MovieRepository
import kotlinx.coroutines.launch

class MovieViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    private val _movies = MutableLiveData<List<Movie>>()

    val movies: LiveData<List<Movie>>
        get() = _movies

    fun searchMovies(query: String) {
        viewModelScope.launch {
            try {
                val result = movieRepository.searchMovies(query)
                _movies.postValue(result)
            } catch (e: Exception) {
                // Handle network or other errors
            }
        }
    }
}
