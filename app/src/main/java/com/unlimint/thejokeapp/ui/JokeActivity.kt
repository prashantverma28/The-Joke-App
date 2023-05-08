package com.unlimint.thejokeapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.unlimint.thejokeapp.database.Joke
import com.unlimint.thejokeapp.R
import com.unlimint.thejokeapp.viewmodel.JokeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class JokeActivity : AppCompatActivity() {
    private lateinit var jokeList: RecyclerView
    private lateinit var jokeAdapter: JokeAdapter
    private lateinit var arrayList: ArrayList<Joke>
    private val jokeViewModel by viewModel<JokeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_joke)
        jokeList = findViewById(R.id.jokeList)
        arrayList = ArrayList()
        jokeAdapter = JokeAdapter()
        jokeList.apply {
            layoutManager = LinearLayoutManager(this@JokeActivity)
            adapter = jokeAdapter
        }
        jokeViewModel.jokes.observe(this) {
            jokeAdapter.updateJokeListItems(it)
            jokeList.scrollToPosition(it.size - 1)
        }
        jokeViewModel.loadData()
    }
}