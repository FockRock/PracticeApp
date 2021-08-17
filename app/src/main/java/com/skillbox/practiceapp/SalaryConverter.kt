package com.skillbox.practiceapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.skillbox.practiceapp.databinding.SalaryConverterBinding

class SalaryConverter: AppCompatActivity() {

    lateinit var bindingClass: SalaryConverterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = SalaryConverterBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        bindingClass.bConvert.setOnClickListener{
            bindingClass.tvResult.visibility = View.VISIBLE
            convert(bindingClass.evSalary.text.toString().toInt())
        }
    }

    private fun convert(a: Int) {
        val res = (a/73.5).toInt().toString() + " $"
        bindingClass.tvResult.text = res
    }
}