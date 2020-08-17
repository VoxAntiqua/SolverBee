package com.andrew_padgett.solverbee.ui.results


import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.io.File
import java.io.IOException
import java.io.InputStream


class ResultsViewModel(private val requiredLetter: String,
                       private val availableLetters: String,
                       application: Application) : AndroidViewModel(application) {

        companion object {
                const val FILENAME = "wordlist_min_4_chars.txt"
        }

        private val allLetters = requiredLetter + availableLetters


        // LiveData for list of words that match constraints
        private var _wordList = MutableLiveData<MutableList<String>>(mutableListOf())
        val wordList: MutableLiveData<MutableList<String>>
                get() = _wordList


        init {
                application.assets.open(FILENAME).bufferedReader().use { it ->
                        it.forEachLine {
                                if (it.contains(requiredLetter)) {
                                        var isValidWord = true
                                        availableLetterCheck@ for (char in it) {
                                                if (char.isLetter() && !allLetters.contains(char)) {
                                                        isValidWord = false
                                                        break@availableLetterCheck
                                                }
                                        }
                                        if (isValidWord) {
                                                _wordList.value?.add(it)
                                        }
                                }
                        }
                }
        }

}