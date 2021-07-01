package com.skillbox.practiceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.core.view.isVisible
import com.skillbox.practiceapp.databinding.PracticeCalculateBinding

class PracticeCalculateActivity : AppCompatActivity() {

    private lateinit var bindingClass: PracticeCalculateBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = PracticeCalculateBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        val emailBlank = intent.getStringExtra("email")?.isBlank()

        if (emailBlank != true) {
            bindingClass.tEmail.isVisible = true
            bindingClass.myEmail.text = intent.getStringExtra("email")
        }

        bindingClass.calculate.setOnClickListener {

            val lessons = bindingClass.lessonNumber.text.toString().toDouble()
            val watched = bindingClass.watchNumber.text.toString().toDouble()
            val result = ((100/lessons)*watched).toInt()

            progressBar()

            Handler().postDelayed({
                bindingClass.progress.text = "$result%"

                    when(result){
                        in 0..19 -> {
                            magic(R.color.black, R.drawable.dead, "Отвратительно")
                            bindingClass.progress.setTextColor(getColor(R.color.white))
                        }
                        in 20..39 -> magic(R.color.red, R.drawable.angry, "Плохо")
                        in 40..79 -> magic(R.color.yellow, R.drawable.normal, "Нормально")
                        in 80..100 -> magic(R.color.green, R.drawable.happy, "Отлично!")
                        else -> getColor(R.color.white)
                    }
            },2000)
        }
    }

    private fun magic(Color: Int, Image: Int, statusTemp: String) {
        bindingClass.progress.setBackgroundColor(getColor(Color))
        bindingClass.smile.isVisible = true
        bindingClass.smile.setImageResource(Image)
        bindingClass.textStatus.text = statusTemp
    }

    private fun progressBar() {
        bindingClass.calculate.isEnabled = false
        bindingClass.progressBar.isVisible = true

        Handler().postDelayed({
            bindingClass.calculate.isEnabled = true
            bindingClass.progressBar.isVisible = false
            Toast.makeText(this, "Calculation Complete!", Toast.LENGTH_SHORT).show()
        }, 2000)
    }
}