package com.andrew_padgett.solverbee.ui.results

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.andrew_padgett.solverbee.databinding.ResultsFragmentBinding

class ResultsFragment : Fragment() {

    companion object {
        fun newInstance() = ResultsFragment()
    }

    private lateinit var viewModel: ResultsViewModel
    private var _binding: ResultsFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ResultsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ResultsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}