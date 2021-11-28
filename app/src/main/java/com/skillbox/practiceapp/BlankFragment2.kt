package com.skillbox.practiceapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.skillbox.practiceapp.databinding.FragmentBlank2Binding

class BlankFragment2 : Fragment() {

    lateinit var binding: FragmentBlank2Binding
    private val dataModel: DataModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBlank2Binding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        dataModel.messageFragment2.observe(activity as LifecycleOwner, {
            binding.tvMessage.text = it
        })

        binding.bSendActivity.setOnClickListener {
            dataModel.message.value = "Hello Activity from Fragment-2"
        }
        binding.bSendFragment1.setOnClickListener {
            dataModel.messageFragment1.value = "Hello from Fragment-2"
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = BlankFragment2()
    }
}