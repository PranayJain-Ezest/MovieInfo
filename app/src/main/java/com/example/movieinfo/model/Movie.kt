package com.example.movieinfo.model



data class Movie(
    val id: Int,
    val overview: String,
    val poster_path: String,
    val release_date: String,
    val revenue: Int,
    val title: String,
    )