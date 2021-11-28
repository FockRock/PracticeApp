package com.skillbox.practiceapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.skillbox.practiceapp.databinding.FragmentBlankBinding

class BlankFragment : Fragment() {

    lateinit var binding: FragmentBlankBinding
    private val dataModel: DataModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBlankBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        dataModel.messageFragment1.observe(activity as LifecycleOwner, {
            binding.tvMessage.text = it
        })
        binding.bSendFragment2.setOnClickListener {
            dataModel.messageFragment2.value = "Hello from Fragment-1"
        }
        binding.bSendActivity.setOnClickListener {
            dataModel.message.value = "Hello Activity from Fragment-1"
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = BlankFragment()
    }
}