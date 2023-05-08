package com.unlimint.thejokeapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.unlimint.thejokeapp.database.Joke
import com.unlimint.thejokeapp.repository.JokeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class JokeViewModel(private val jokeRepository: JokeRepository) : ViewModel() {

    private val _jokes = MutableLiveData<ArrayList<Joke>>()
    val jokes: LiveData<ArrayList<Joke>>
        get() = _jokes

    fun loadData() {
        viewModelScope.launch(Dispatchers.IO) {
            jokeRepository.getLocalJokeList()?.let {
                _jokes.postValue(it)
            }
            jokeRepository.getRemoteJokeList()?.let {
                _jokes.postValue(it)
            }
            delay(60 * 1000)
            loadData()
        }
    }

}
