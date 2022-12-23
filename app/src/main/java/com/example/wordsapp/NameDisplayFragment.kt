package com.example.wordsapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.wordsapp.databinding.FragmentDetailBinding
import com.example.wordsapp.databinding.FragmentNameDisplayBinding

class NameDisplayFragment : Fragment() {
    private var _binding: FragmentNameDisplayBinding? = null
    private val binding get() = _binding!!
    private lateinit var name: String
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            arguments?.let {
                name = it.getString("name").toString()
            }
        }


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentNameDisplayBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.output.text = name

        binding.output.setOnClickListener{
            val queryUrl: Uri = Uri.parse("${DetailFragment.SEARCH_PREFIX}${name}")
            val intent = Intent(Intent.ACTION_VIEW, queryUrl)
            context?.startActivity(intent)
        }
    }


}