package com.skillbox.practiceapp

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.skillbox.practiceapp.databinding.FragmentsBinding

class Fragments: AppCompatActivity() {

    lateinit var binding: FragmentsBinding

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        binding = FragmentsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        openFragment(BlankFragment.newInstance(), R.id.fragmentContainer)
    }

    private fun openFragment(f: Fragment, idHolder: Int) {
        supportFragmentManager
            .beginTransaction()
            .replace(idHolder, f)
            .commit()
    }
}