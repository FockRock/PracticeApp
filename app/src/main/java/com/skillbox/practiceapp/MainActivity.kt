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
                            bindingClass.progress.setBackgroundColor(getColor(R.color.black))
                            bindingClass.progress.setTextColor(getColor(R.color.white))
                            bindingClass.smile.isVisible = true
                            bindingClass.smile.setImageResource(R.drawable.dead)
                        }
                        in 20..39 -> {
                            bindingClass.progress.setBackgroundColor(getColor(R.color.red))
                            bindingClass.smile.isVisible = true
                            bindingClass.smile.setImageResource(R.drawable.angry)
                        }
                        in 40..79 -> {
                            bindingClass.progress.setBackgroundColor(getColor(R.color.yellow))
                            bindingClass.smile.isVisible = true
                            bindingClass.smile.setImageResource(R.drawable.normal)
                        }
                        in 80..100 -> {
                            bindingClass.progress.setBackgroundColor(getColor(R.color.green))
                            bindingClass.smile.isVisible = true
                            bindingClass.smile.setImageResource(R.drawable.happy)
                        }
                        else -> getColor(R.color.white)
                    }
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