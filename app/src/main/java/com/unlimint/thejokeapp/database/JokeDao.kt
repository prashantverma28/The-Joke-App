package com.unlimint.thejokeapp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface JokeDao {

    @Insert
    fun insert(jokeTable: Joke)

    @Query("select * from joke_table order by id desc limit 10")
    fun getAllJokes(): List<Joke>?
}