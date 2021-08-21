package com.skillbox.practiceapp

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.skillbox.practiceapp.databinding.SignInUpBinding

class SignInUpActivity : AppCompatActivity() {

    lateinit var bindingClass: SignInUpBinding

    private var intentResult = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = SignInUpBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        intentResult = intent.getStringExtra(Constance.SIGN_STATE)!!
        if (intentResult == Constance.SIGN_IN_STATE) {
            bindingClass.edName.visibility = View.GONE
        }
    }

    fun done(view: View) {

        if (intentResult == Constance.SIGN_UP_STATE) {

            intent.putExtra(Constance.NAME, bindingClass.edName.text.toString())
            intent.putExtra(Constance.EMAIL, bindingClass.edEmail.text.toString())
            intent.putExtra(Constance.PASSWORD, bindingClass.edPassword.text.toString())
            setResult(RESULT_OK, intent)
            finish()

        } else {

            intent.putExtra(Constance.EMAIL, bindingClass.edEmail.text.toString())
            intent.putExtra(Constance.PASSWORD, bindingClass.edPassword.text.toString())
            setResult(RESULT_OK, intent)
            finish()

        }
    }
}