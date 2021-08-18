package com.example.onepiecequiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.onepiecequiz.databinding.FragmentMainScreenBinding


class FragmentMainScreen : Fragment() {
    lateinit var binding: FragmentMainScreenBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate( inflater, R.layout.fragment_main_screen,container, false )
        binding.textView.text
        binding.textView2.text
        binding.startButton.setOnClickListener {
            val action = FragmentMainScreenDirections.actionFragmentMainScreenToFragmentQuestions()
            findNavController().navigate(action)
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding
    }


}