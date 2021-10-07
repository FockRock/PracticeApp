package com.skillbox.practiceapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.skillbox.practiceapp.databinding.PosterItemBinding

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieHolder>() {

    val movieList = ArrayList<Movie>()

    class MovieHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = PosterItemBinding.bind(item)
        fun bind(movie: Movie) = with(binding) {
            poster.setImageResource(movie.poster)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.poster_item, parent, false)
        return MovieHolder(view)
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        holder.bind(movieList[position])
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    fun addMovie (movie: Movie) {
        movieList.add(movie)
        notifyDataSetChanged()
    }

}