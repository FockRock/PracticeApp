package com.skillbox.practiceapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.skillbox.practiceapp.databinding.FragmentsBinding

class Fragments: AppCompatActivity() {

    lateinit var bindingClass: FragmentsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = FragmentsBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        openFragment(BlankFragment.newInstance(), R.id.fragmentContainer)

        bindingClass.bSwitch.setOnClickListener{
            openFragment(BlankFragment2.newInstance(), R.id.fragmentContainer)
        }
    }

    private fun openFragment(f: Fragment, idHolder: Int) {
        supportFragmentManager
            .beginTransaction()
            .replace(idHolder, f)
            .commit()
    }
}