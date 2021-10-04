package com.skillbox.practiceapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.skillbox.practiceapp.databinding.TestBinding

class Test : AppCompatActivity() {

    lateinit var bindingClass: TestBinding
    private var launcher: ActivityResultLauncher<Intent>? = null
    private var salary: ActivityResultLauncher<Intent>? = null
    private var practiceProgress: ActivityResultLauncher<Intent>? = null

    var name = ""
    var email = ""
    var password = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = TestBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        salary = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            result: ActivityResult ->
            if (result.resultCode == RESULT_OK) {
                val text = result.data?.getStringExtra(Constance.KEY1)
                bindingClass.salaryTv.text = "Salary: $text"
            }
        }

        practiceProgress = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            result: ActivityResult ->
            if (result.resultCode == RESULT_OK) {
                val text = result.data?.getStringExtra("key")
                bindingClass.progressTv.text = "Progress: $text"
            }
        }

        launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            result: ActivityResult ->
            if (result.resultCode == Constance.SIGN_UP) {

                name = result.data?.getStringExtra(Constance.NAME)!!
                email = result.data?.getStringExtra(Constance.EMAIL)!!
                password = result.data?.getStringExtra(Constance.PASSWORD)!!

                bindingClass.textView.text = "Please, Sign In"
                bindingClass.bSignUp.visibility = View.GONE
                bindingClass.bSignIn.visibility = View.VISIBLE

            } else if (result.resultCode == Constance.SIGN_IN) {

                val e = result.data?.getStringExtra(Constance.EMAIL)
                val p = result.data?.getStringExtra(Constance.PASSWORD)

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
    }

    fun calculateProgress(view: View) {
        practiceProgress?.launch(Intent(this, PracticeCalculateActivity::class.java))
    }

    fun convertSalary(view: View) {
        salary?.launch(Intent(this, SalaryConverter::class.java))
    }

    fun profitCalculate(view: View) {
        val i = Intent(this, Profit::class.java)
        startActivity(i)
    }

    fun signIn(view: View) {
        val i = Intent(this, SignInUpActivity::class.java)
        i.putExtra(Constance.SIGN_STATE, Constance.SIGN_IN_STATE)
        launcher?.launch(i)
    }

    fun signUp(view: View) {
        val i = Intent(this, SignInUpActivity::class.java)
        i.putExtra(Constance.SIGN_STATE, Constance.SIGN_UP_STATE)
        launcher?.launch(i)
    }
}