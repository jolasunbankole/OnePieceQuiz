package com.example.onepiecequiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.onepiecequiz.databinding.FragmentWonBinding


class FragmentWon : Fragment() {
    lateinit var binding: FragmentWonBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = DataBindingUtil.inflate(inflater, R.layout.fragment_won, container,false)
        binding.TheKing.drawable
        binding.winner.text
        binding.title.text
        binding.button.setOnClickListener {
            val action = FragmentWonDirections.actionFragmentWonToFragmentMainScreen()
            findNavController().navigate(action)
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding
    }


}