package com.skillbox.practiceapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.skillbox.practiceapp.databinding.SignInUpBinding

class SignInUpActivity: AppCompatActivity() {

    private lateinit var bindingClass: SignInUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = SignInUpBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)


    }
}