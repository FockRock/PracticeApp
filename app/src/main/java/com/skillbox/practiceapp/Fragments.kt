package com.skillbox.practiceapp

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStore
import com.skillbox.practiceapp.databinding.FragmentsBinding

class Fragments: AppCompatActivity() {

    lateinit var bindingClass: FragmentsBinding

    private val dataModel: DataModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = FragmentsBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        openFragment(BlankFragment.newInstance(), R.id.fragmentContainer1)
        openFragment(BlankFragment2.newInstance(), R.id.fragmentContainer2)

        dataModel.message.observe(this, {
            bindingClass.tvResult.text = it
        })
    }

    private fun openFragment(f: Fragment, idHolder: Int) {
        supportFragmentManager
            .beginTransaction()
            .replace(idHolder, f)
            .commit()
    }
}