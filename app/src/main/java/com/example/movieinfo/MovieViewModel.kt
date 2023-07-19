package com.example.movieinfo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieinfo.retrofit.MovieApiService
import com.example.movieinfo.model.Movie
import com.example.movieinfo.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

// MovieViewModel.kt
@HiltViewModel
class MovieViewModel @Inject constructor(private val repository: MovieRepository) : ViewModel() {
    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>> get() = _movies

    fun searchMovies(query: String) {
        viewModelScope.launch {
            try {
                val response = repository.searchMovies(query)
                if (response.isSuccessful) {
                    val movieList = response.body()?.results ?: emptyList()
                    _movies.value = movieList
                } else {
                    // Handle error
                }
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
}


