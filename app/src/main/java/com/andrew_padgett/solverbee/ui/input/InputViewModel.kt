package com.andrew_padgett.solverbee.ui.input

import androidx.lifecycle.*

class InputViewModel: ViewModel() {

    private var _navigateToResults = MutableLiveData<Boolean?>()
    val navigateToResults: LiveData<Boolean?>
        get() =_navigateToResults

    // String input fields for validation
    val requiredLetter: MutableLiveData<String> by lazy { MutableLiveData<String>()}
    val availableLetters: MutableLiveData<String> by lazy { MutableLiveData<String>()}
    val valid: MediatorLiveData<Boolean> = MediatorLiveData()
    val inputChanged: (Any) -> Unit = cc@ {
        if (requiredLetter.value != null && availableLetters.value != null) {
            valid.value = requiredLetter.value!!.length == 1 &&
                    availableLetters.value!!.length >= 3 &&
                    requiredLetter.value!!.all { it.isLetter() } &&
                    availableLetters.value!!.all { it.isLetter() }
            return@cc
        }
        valid.value = false
    }

    init {
        valid.addSource(requiredLetter, inputChanged)
        valid.addSource(availableLetters, inputChanged)
    }

    fun onSubmitInput() {
        _navigateToResults.value = true
    }

    fun doneNavigating() {
        _navigateToResults.value = null
    }

}