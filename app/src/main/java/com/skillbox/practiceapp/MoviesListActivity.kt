package com.skillbox.practiceapp

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.skillbox.practiceapp.databinding.MovieListBinding
import com.skillbox.practiceapp.databinding.ProfitBinding

class MoviesListActivity: AppCompatActivity() {
    lateinit var binding: MovieListBinding
    private val adapter = MovieAdapter()
    private val imageIdList = listOf(
        R.drawable.dracula
    )

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        binding = MovieListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        binding.apply {
            rcView.layoutManager = GridLayoutManager(this@MoviesListActivity, 3)
            rcView.adapter = adapter
            buttonAdd.setOnClickListener {
                val movie = Movie(imageIdList[0])
                adapter.addMovie(movie)
            }
        }
    }
}