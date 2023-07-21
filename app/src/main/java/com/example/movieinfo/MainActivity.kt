package com.example.movieinfo

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieinfo.databinding.ActivityMainBinding
import com.example.movieinfo.util.MovieAdapter
import dagger.hilt.android.AndroidEntryPoint

// MainActivity.kt
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var movieAdapter: MovieAdapter

    private val movieViewModel: MovieViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Create the binding object
        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.searchButton.setOnClickListener {
            val query = binding.searchEditText.text.toString().trim()
            if (query.isNotEmpty()) {
                movieViewModel.searchMovies(query)
            }
        }

        movieViewModel.movies.observe(this) { movies ->
            if (movies.isEmpty()) {
                binding.resultsRecyclerView.visibility = View.GONE
                binding.noResultsTextView.visibility = View.VISIBLE
            } else {
                binding.resultsRecyclerView.visibility = View.VISIBLE
                binding.noResultsTextView.visibility = View.GONE

                movieAdapter = MovieAdapter(list = movies)
                binding.resultsRecyclerView.layoutManager = LinearLayoutManager(this)
                binding.resultsRecyclerView.adapter = movieAdapter
            }
        }
    }
}


/*
Api
private const val KEY_ = "22ef6f04843e16d522550c36627c46d2"

API read access token= eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI4ZDdiMWJlN2M0NWQ5ZGMzODQwODhhMmVkZGM2MjI0ZCIsInN1
YiI6IjY0YjEyOTk3ZDIzNmU2MDBjNTg2ZmIyMSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.RVdsX0f3mRegeHPpKvo8tBdh6HT1b0Pa5YbOsFHlRP8*/
