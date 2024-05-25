package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.randomButton.setOnClickListener {
            val count = binding.textviewFirst.text.toString().toInt()
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(count)
            findNavController().navigate(action)
        }

        binding.toastButton.setOnClickListener {
            val myToast = Toast.makeText(context, "Hello Toast!", Toast.LENGTH_LONG)
            myToast.show()
        }

        binding.countButton.setOnClickListener {
            countMe(view)
        }
    }

    private fun countMe(view: View) {
        val showCountTextView = binding.textviewFirst
        val countString = showCountTextView.text.toString()
        var count = countString.toInt()
        count++
        showCountTextView.text = count.toString()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
