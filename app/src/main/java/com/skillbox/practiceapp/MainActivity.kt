package com.skillbox.practiceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.widget.Toast
import androidx.core.view.isVisible
import com.skillbox.practiceapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var bindingClass: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        val lessons = bindingClass.lessonNumber.text.toString().toInt()
        val watched = bindingClass.watchNumber.text.toString().toInt()
        val result = ((100/lessons)*watched)

        bindingClass.calculate.setOnClickListener {
            progressBar()
            Handler().postDelayed({
                bindingClass.progress.text = "$result%"
                bindingClass.progress.setBackgroundColor(
                    when(result){
                        in 0..19 -> getColor(R.color.black)
                        in 20..39 -> getColor(R.color.red)
                        in 40..79 -> getColor(R.color.yellow)
                        in 80..100 -> getColor(R.color.green)
                        else -> getColor(R.color.white)
                    }
                )
            },2000)
        }

    }

    private fun progressBar() {
        bindingClass.calculate.isEnabled = false
        bindingClass.progressBar.isVisible = true

        Handler().postDelayed({
            bindingClass.calculate.isEnabled = true
            bindingClass.progressBar.isVisible = false
            Toast.makeText(this, "Calculation complete!", Toast.LENGTH_SHORT).show()
        }, 2000)
    }
}