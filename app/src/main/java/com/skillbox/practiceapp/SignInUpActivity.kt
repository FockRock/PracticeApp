package com.skillbox.practiceapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.skillbox.practiceapp.databinding.SignInUpBinding

class SignInUpActivity : AppCompatActivity() {

    private lateinit var bindingClass: SignInUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = SignInUpBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        val state = intent.getStringExtra(Constance.SIGN_STATE)

        if (state == Constance.SIGN_IN_STATE) {
            bindingClass.edEmail.visibility = View.GONE
        }
    }

    fun logIn(view: View) {
        val intent = Intent(this, PracticeCalculateActivity::class.java)
        startActivity(intent)
    }

    fun done(view: View) {
        finish()
    }
}