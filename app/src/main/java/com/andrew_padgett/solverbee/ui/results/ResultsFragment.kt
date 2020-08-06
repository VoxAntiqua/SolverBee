package com.andrew_padgett.solverbee.ui.results

import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.andrew_padgett.solverbee.databinding.ResultsFragmentBinding

class ResultsFragment : Fragment() {

    companion object {
        fun newInstance() = ResultsFragment()
    }

    private lateinit var resultsViewModel: ResultsViewModel
    private var _binding: ResultsFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ResultsFragmentBinding.inflate(inflater, container, false)
        val arguments = ResultsFragmentArgs.fromBundle(requireArguments())
        val application = requireNotNull(this.activity).application
        val viewModelFactory = ResultsViewModelFactory(arguments.requiredLetter, arguments.availableLetters, application)
        val resultsViewModel = ViewModelProvider(this, viewModelFactory).get(ResultsViewModel::class.java)

        binding.resultsViewModel = resultsViewModel
        binding.lifecycleOwner = this

        binding.textView2.text = arguments.requiredLetter + " " + arguments.availableLetters

        resultsViewModel.wordList.observe(viewLifecycleOwner, Observer {
            binding.textView2.text = it.toString()
        })


        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}