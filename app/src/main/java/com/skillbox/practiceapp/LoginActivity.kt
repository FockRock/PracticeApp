package com.skillbox.practiceapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.skillbox.practiceapp.databinding.LoginActivityBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var bindingClass: LoginActivityBinding

    private var name = ""
    private var email = ""
    private var password = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = LoginActivityBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

    }


    fun signIn(view: View) {
        val l = Intent(this, SignInUpActivity::class.java)
        l.putExtra(Constance.SIGN_STATE, Constance.SIGN_IN_STATE)
        startActivityForResult(l, Constance.REQUEST_CODE_SIGN_IN)
    }

    fun signUp(view: View) {
        val s = Intent(this, SignInUpActivity::class.java)
        s.putExtra(Constance.SIGN_STATE, Constance.SIGN_UP_STATE)
        startActivityForResult(s, Constance.REQUEST_CODE_SIGN_UP)
    }

}