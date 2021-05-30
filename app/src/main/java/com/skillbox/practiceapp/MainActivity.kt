package com.skillbox.practiceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.skillbox.practiceapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var bindingClass: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        val lessons = 25
        val watched = 10
        val result = (100/lessons)*watched

        bindingClass.calculate.setOnClickListener {
            bindingClass.lessonNumber.text = lessons.toString()
            bindingClass.watchNumber.text = watched.toString()
            bindingClass.progress.text = "$result%"
        }
    }
}