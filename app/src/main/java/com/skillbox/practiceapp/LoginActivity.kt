package com.skillbox.practiceapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.skillbox.practiceapp.databinding.LoginActivityBinding

class LoginActivity: AppCompatActivity() {

    private lateinit var bindingClass: LoginActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = LoginActivityBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

    }

    fun login(view: View) {
        val l = Intent(this, PracticeCalculateActivity::class.java)
        startActivity(l)
    }

}