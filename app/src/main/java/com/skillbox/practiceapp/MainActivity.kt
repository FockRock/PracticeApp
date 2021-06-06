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

        bindingClass.calculate.setOnClickListener {

            val lessons = bindingClass.lessonNumber.text.toString().toDouble()
            val watched = bindingClass.watchNumber.text.toString().toDouble()
            val result = ((100/lessons)*watched)

            progressBar()

            Handler().postDelayed({
                bindingClass.progress.text = "$result%"
                bindingClass.progress.setBackgroundColor(
                    when(result){
                        in 0.0..19.9 -> getColor(R.color.black)
                        in 20.0..39.9 -> getColor(R.color.red)
                        in 40.0..79.9 -> getColor(R.color.yellow)
                        in 80.0..100.0 -> getColor(R.color.green)
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