package com.example.recipees.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recipees.R
import com.example.recipees.model.Category


class MainAdapter : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
    private var   list:List<Category> = java.util.ArrayList()
    fun setArray(list:List<Category>){
        this.list = list
    }


    class MainViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var textM = itemView.findViewById<TextView>(R.id.textM)
        var image = view.findViewById<ImageView>(R.id.imageView1)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.main_item , parent , false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.textM.text = list.get(position).strCategory
        Glide.with(holder.itemView.rootView.context).load( list[position].strCategoryThumb).into(holder.image)
    }
}