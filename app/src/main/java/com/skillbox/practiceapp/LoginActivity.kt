package com.skillbox.practiceapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.skillbox.practiceapp.databinding.LoginActivityBinding

class LoginActivity: AppCompatActivity() {

    private lateinit var bindingClass: LoginActivityBinding

    private var name = ""
    private var email = ""
    private var password = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = LoginActivityBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }

    fun signIn(view: View) {
        val l = Intent(this, PracticeCalculateActivity::class.java)
        startActivity(l)
    }

    fun signUp(view: View) {
        val s = Intent(this, SignInUpActivity::class.java)
        startActivityForResult(s, 235)
    }

}