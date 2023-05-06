package com.unlimint.thejokeapp.utils

import androidx.recyclerview.widget.DiffUtil
import com.unlimint.thejokeapp.database.Joke

class EmployeeDiffCallback(
    private val oldJokeList: List<Joke>,
    private val newJokeList: List<Joke>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldJokeList.size
    }

    override fun getNewListSize(): Int {
        return newJokeList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldJokeList[oldItemPosition].jokeName == newJokeList[newItemPosition].jokeName
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val (_, jokeName) = oldJokeList[oldItemPosition]
        val (_, jokeName1) = newJokeList[newItemPosition]
        return jokeName == jokeName1
    }

    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        return super.getChangePayload(oldItemPosition, newItemPosition)
    }
}