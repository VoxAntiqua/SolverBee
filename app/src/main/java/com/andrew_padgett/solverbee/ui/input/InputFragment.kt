package com.andrew_padgett.solverbee.ui.input

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.andrew_padgett.solverbee.databinding.InputFragmentBinding
import com.google.android.material.snackbar.Snackbar

class InputFragment : Fragment() {

    companion object {
        fun newInstance() = InputFragment()
    }

    private lateinit var inputViewModel: InputViewModel
    private var _binding: InputFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = InputFragmentBinding.inflate(inflater, container, false)

        val inputViewModelFactory = InputViewModelFactory()
        val inputViewModel = ViewModelProvider(this, inputViewModelFactory).get(InputViewModel::class.java)

        binding.inputViewModel = inputViewModel
        binding.setLifecycleOwner(this)

        inputViewModel.navigateToResults.observe(viewLifecycleOwner, Observer {
            if (it == true) {
                this.findNavController().navigate(InputFragmentDirections.actionInputFragmentToResultsFragment(inputViewModel.requiredLetter.value!!, inputViewModel.availableLetters.value!!))
                Snackbar.make(activity?.findViewById(android.R.id.content)!!, "navigateToResults is true", Snackbar.LENGTH_SHORT).show()
                inputViewModel.doneNavigating()
            } else if (it == false) {
                Snackbar.make(activity?.findViewById(android.R.id.content)!!, "Incorrect input", Snackbar.LENGTH_SHORT).show()
            }
        })

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}