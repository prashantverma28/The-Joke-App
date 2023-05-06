package com.unlimint.thejokeapp.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "joke_table")
data class Joke(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @SerializedName("joke") val jokeName: String
)