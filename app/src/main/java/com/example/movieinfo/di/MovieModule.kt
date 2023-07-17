package com.example.movieinfo.di

import com.example.movieinfo.MovieViewModel
import com.example.movieinfo.api.MovieApiService
import com.example.movieinfo.network.ApiService
import com.example.movieinfo.repository.MovieRepository
import com.example.movieinfo.util.MovieAdapter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MovieModule {
    @Provides
    fun provideMovieApiService(): MovieApiService {
        return ApiService.movieApi
    }

    @Provides
    fun provideMovieRepository(movieApiService: MovieApiService): MovieRepository {
        return MovieRepository(movieApiService)
    }

    @Provides
    @Singleton
    fun provideMovieAdapter(): MovieAdapter {
        return MovieAdapter()
    }

    @Provides
    fun provideMovieViewModel(movieRepository: MovieRepository): MovieViewModel {
        return MovieViewModel(movieRepository)
    }
}
