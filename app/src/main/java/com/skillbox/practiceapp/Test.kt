package com.skillbox.practiceapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.skillbox.practiceapp.databinding.TestBinding

class Test : AppCompatActivity() {

    lateinit var bindingClass: TestBinding

    var name = ""
    var email = ""
    var password = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = TestBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == Constance.REQUEST_CODE_SIGN_UP) {

            name = data?.getStringExtra(Constance.NAME)!!
            email = data.getStringExtra(Constance.EMAIL)!!
            password = data.getStringExtra(Constance.PASSWORD)!!

            bindingClass.textView.text = "Please, Sign In"
            bindingClass.bSignUp.visibility = View.GONE
            bindingClass.bSignIn.visibility = View.VISIBLE

        } else if (requestCode == Constance.REQUEST_CODE_SIGN_IN) {

            val e = data?.getStringExtra(Constance.EMAIL)
            val p = data?.getStringExtra(Constance.PASSWORD)

            if (email == e && password == p) {

                bindingClass.textView.text = "Добро пожаловать, $name"
                bindingClass.bSignIn.visibility = View.GONE
                bindingClass.bProfit.visibility = View.VISIBLE
                bindingClass.bSConvert.visibility = View.VISIBLE
                bindingClass.cb.visibility = View.VISIBLE

            } else {

                bindingClass.textView.text = "Неверная почта или пароль!"

            }
        }
    }

    fun calculateProgress(view: View) {
        val i = Intent(this, PracticeCalculateActivity::class.java)
        startActivity(i)
    }

    fun convertSalary(view: View) {
        val i = Intent(this, SalaryConverter::class.java)
        startActivity(i)
    }

    fun profitCalculate(view: View) {
        val i = Intent(this, Profit::class.java)
        startActivity(i)
    }

    fun signIn(view: View) {
        val i = Intent(this, SignInUpActivity::class.java)
        i.putExtra(Constance.SIGN_STATE, Constance.SIGN_IN_STATE)
        startActivityForResult(i, Constance.REQUEST_CODE_SIGN_IN)
    }

    fun signUp(view: View) {
        val i = Intent(this, SignInUpActivity::class.java)
        i.putExtra(Constance.SIGN_STATE, Constance.SIGN_UP_STATE)
        startActivityForResult(i, Constance.REQUEST_CODE_SIGN_UP)
    }
}