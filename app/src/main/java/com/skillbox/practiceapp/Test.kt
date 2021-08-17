package com.skillbox.practiceapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.skillbox.practiceapp.databinding.TestBinding

class Test: AppCompatActivity() {

    lateinit var bindingClass: TestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = TestBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
    }

    fun calculateProgress (view: View) {
        val i = Intent(this, PracticeCalculateActivity::class.java)
        startActivityForResult(i, Constance.REQUEST_CODE_CALCULATE)
    }

    fun convertSalary (view: View) {
        val i = Intent (this, SalaryConverter::class.java)
        startActivityForResult(i, Constance.REQUEST_CODE_CONVERT)
    }

    fun profitCalculate (view: View) {
        val i = Intent (this, Profit::class.java)
        startActivityForResult(i, Constance.REQUEST_CODE_PROFIT)
    }
}