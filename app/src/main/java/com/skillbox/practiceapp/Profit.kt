package com.skillbox.practiceapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.skillbox.practiceapp.databinding.ProfitBinding

class Profit: AppCompatActivity() {

    lateinit var bindingClass: ProfitBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ProfitBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        bindingClass.button2.setOnClickListener {
            bindingClass.tvResult.visibility = View.VISIBLE
            calculate(bindingClass.editTextNumber.text.toString().toDouble())
        }
    }

    private fun calculate(a: Double) {
        val b = (a/100.0) * (100.0 - bindingClass.editPercent.text.toString().toDouble())
        bindingClass.tvResult.text = b.toString()
    }

    fun back(view: View) {
        finish()
    }
}