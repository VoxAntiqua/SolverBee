package com.andrew_padgett.solverbee.ui.results

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ResultsViewModelFactory(
    private val requiredLetter: String,
    private val availableLetters: String) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ResultsViewModel::class.java)) {
            return ResultsViewModel(requiredLetter, availableLetters) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
