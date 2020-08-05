package com.andrew_padgett.solverbee.ui.input

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InputViewModel: ViewModel() {

    private var _navigateToResults = MutableLiveData<Boolean?>()
    val navigateToResults: LiveData<Boolean?>
        get() =_navigateToResults

    fun onSubmitInput() {
        _navigateToResults.value = true
    }

    fun doneNavigating() {
        _navigateToResults.value = null
    }

}