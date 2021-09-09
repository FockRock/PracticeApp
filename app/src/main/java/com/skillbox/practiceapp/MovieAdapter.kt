package com.skillbox.practiceapp

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.skillbox.practiceapp.databinding.PosterItemBinding

class MovieAdapter: RecyclerView.Adapter<MovieAdapter.MovieHolder>() {

    class MovieHolder(item: View): RecyclerView.ViewHolder(item) {
        private val binding = PosterItemBinding.bind(item)

        fun bind (movie: Movie) {
            binding.poster.setImageResource(movie.poster)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}