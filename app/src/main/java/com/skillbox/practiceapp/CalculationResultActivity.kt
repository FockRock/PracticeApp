package com.skillbox.practiceapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.skillbox.practiceapp.databinding.CalculationResultBinding

class CalculationResultActivity: AppCompatActivity() {
    private lateinit var bindingClass: CalculationResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = CalculationResultBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        bindingClass.status.text = intent.getStringExtra("status")

    }

    fun goBack(view: View) {
        finish()
    }

}