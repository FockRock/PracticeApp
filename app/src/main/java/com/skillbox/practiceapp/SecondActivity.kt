package com.skillbox.practiceapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.skillbox.practiceapp.databinding.ActivitySecondBinding

class SecondActivity: AppCompatActivity() {
    lateinit var bindingClass: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        bindingClass.status.text = intent.getStringExtra("status")

    }

}