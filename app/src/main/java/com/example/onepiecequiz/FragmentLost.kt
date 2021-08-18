package com.example.onepiecequiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.onepiecequiz.databinding.FragmentLostBinding


class FragmentLost : Fragment() {
    lateinit var binding: FragmentLostBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_lost, container, false)
        binding.imageView.drawable
        binding.loser.text
        binding.loser2.text
        binding.button2.setOnClickListener {
            val action = FragmentLostDirections.actionFragmentLostToFragmentMainScreen()
            findNavController().navigate(action)
        }
        return binding.root

    }


}