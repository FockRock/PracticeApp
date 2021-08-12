package com.skillbox.practiceapp

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.skillbox.practiceapp.databinding.TestBinding

class Test: AppCompatActivity() {

    lateinit var bindingClass: TestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = TestBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
    }
}