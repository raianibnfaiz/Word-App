package com.example.wordsapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.wordsapp.databinding.FragmentDetailBinding

private var _binding: FragmentDetailBinding? = null
private val binding get() = _binding!!
private lateinit var detail: String

class DetailFragment : Fragment() {
    companion object {
       
        const val NAME = "name"
        const val SEARCH_PREFIX = "https://www.google.com/images?q="
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            detail = it.getString("detail").toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.detailWord.text = detail
        binding.detailWord.setOnClickListener {
            Toast.makeText(context, "yes", Toast.LENGTH_SHORT).show()
            val queryUrl: Uri = Uri.parse("$SEARCH_PREFIX${detail}")
            val intent = Intent(Intent.ACTION_VIEW, queryUrl)
            context?.startActivity(intent)
        }
        binding.displayButton.setOnClickListener {
            val action =DetailFragmentDirections.actionDetailFragmentToNameDisplayFragment(name = binding.inputName.text.toString())
            binding.displayButton.findNavController().navigate(action)
        }
    }
}