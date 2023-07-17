package com.example.movieinfo.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieinfo.R
import com.example.movieinfo.model.Movie

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private var movies: List<Movie> = emptyList()

    fun submitList(movies: List<Movie>) {
        this.movies = movies
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        private val overviewTextView: TextView = itemView.findViewById(R.id.overviewTextView)
        private val posterImageView: ImageView = itemView.findViewById(R.id.posterImageView)

        fun bind(movie: Movie) {
            titleTextView.text = movie.title
            overviewTextView.text = movie.overview


          /*  val poster= "https://api.themoviedb.org/3/movie/${movie.id}/w500${movie.poster_path}"*/

            val poster= "https://image.tmdb.org/t/p/w500${movie.poster_path}"
            Glide.with(itemView.context)
                .load(poster)
                .fitCenter()
                .into(posterImageView)
        }
    }
}

