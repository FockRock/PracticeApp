package com.skillbox.practiceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
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
            val result = ((100/lessons)*watched).toInt()

            progressBar()

            Handler().postDelayed({
                bindingClass.progress.text = "$result%"

                    when(result){
                        in 0..19 -> {
                            magic(R.color.black, R.drawable.dead)
                            bindingClass.progress.setTextColor(getColor(R.color.white))
                        }
                        in 20..39 -> magic(R.color.red, R.drawable.angry)
                        in 40..79 -> magic(R.color.yellow, R.drawable.normal)
                        in 80..100 -> magic(R.color.green, R.drawable.happy)
                        else -> getColor(R.color.white)
                    }
            },2000)
        }
    }

    private fun magic(Color: Int, Image: Int) {
        bindingClass.progress.setBackgroundColor(getColor(Color))
        bindingClass.smile.isVisible = true
        bindingClass.smile.setImageResource(Image)
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