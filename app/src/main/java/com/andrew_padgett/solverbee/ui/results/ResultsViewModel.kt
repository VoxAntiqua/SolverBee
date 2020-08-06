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
                const val FILENAME = "/assets/word_list.txt"
        }


//        val inputStream: InputStream = File(FILENAME).inputStream()
//        val lineList = mutableListOf<String>()

        // LiveData for list of words that match constraints
        private var _wordList = MutableLiveData<MutableList<String>>(mutableListOf())
        val wordList: MutableLiveData<MutableList<String>>
                get() = _wordList


        init {
                application.assets.open("word_list.txt").bufferedReader().use {
                        it.forEachLine {
                                if (it.contains(requiredLetter)) {
                                        _wordList.value?.add(it)
                                }
                        }
                }
        }

}