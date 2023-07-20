package com.example.movieinfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieinfo.retrofit.MovieApiService
import com.example.movieinfo.databinding.ActivityMainBinding
import com.example.movieinfo.retrofit.ApiService
import com.example.movieinfo.repository.MovieRepository
import com.example.movieinfo.util.MovieAdapter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

// MainActivity.kt
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var movieAdapter: MovieAdapter

    @Inject
    lateinit var movieViewModel: MovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Create the binding object
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)


        // Create the Dagger component and inject dependencies
        val component = DaggerMovieComponent.builder()
            .build()
        component.inject(this)

        binding.resultsRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.resultsRecyclerView.adapter = movieAdapter

        binding.searchButton.setOnClickListener {
            val query = binding.searchEditText.text.toString().trim()
            if (query.isNotEmpty()) {
                movieViewModel.searchMovies(query)
            }
        }

        movieViewModel.movies.observe(this, Observer { movies ->
            if (movies.isEmpty()) {
                binding.resultsRecyclerView.visibility = View.GONE
                binding.noResultsTextView.visibility = View.VISIBLE
            } else {
                binding.resultsRecyclerView.visibility = View.VISIBLE
                binding.noResultsTextView.visibility = View.GONE
                movieAdapter.submitList(movies)
            }
        })
    }
}








/*
Api
private const val KEY_ = "22ef6f04843e16d522550c36627c46d2"

API read access token= eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI4ZDdiMWJlN2M0NWQ5ZGMzODQwODhhMmVkZGM2MjI0ZCIsInN1
YiI6IjY0YjEyOTk3ZDIzNmU2MDBjNTg2ZmIyMSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.RVdsX0f3mRegeHPpKvo8tBdh6HT1b0Pa5YbOsFHlRP8*/
