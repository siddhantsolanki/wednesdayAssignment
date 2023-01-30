package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapplication.R

class DataAdapter(private val context: Context?, private val strings: List<String>) :
    RecyclerView.Adapter<DataAdapter.ViewHolder>() {
    var data = strings

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var titleName: TextView = view.findViewById(R.id.text_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_recycler_each, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.titleName.text = data[position]
    }

    override fun getItemCount(): Int = data.size
}