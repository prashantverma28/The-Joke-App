package com.unlimint.thejokeapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.unlimint.thejokeapp.database.Joke
import com.unlimint.thejokeapp.R
import com.unlimint.thejokeapp.utils.EmployeeDiffCallback


class JokeAdapter() : RecyclerView.Adapter<JokeAdapter.ViewHolder>() {

    private var itemList = ArrayList<Joke>()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val joke: TextView = itemView.findViewById(R.id.joke)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_joke, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = itemList[position]
        holder.joke.text = currentItem.jokeName
    }

    override fun getItemCount() = itemList.size

    fun updateJokeListItems(jokeItemList: List<Joke>) {
        val diffCallback = EmployeeDiffCallback(this.itemList, jokeItemList)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        this.itemList.clear()
        this.itemList.addAll(jokeItemList)
        diffResult.dispatchUpdatesTo(this)
    }
}