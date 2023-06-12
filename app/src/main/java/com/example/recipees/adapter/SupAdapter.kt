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


class SupAdapter(private val response: List<Category>) :RecyclerView.Adapter<SupAdapter.SupViewHolder>(){

    class SupViewHolder (view: View) : RecyclerView.ViewHolder(view){

        var title = view.findViewById<TextView>(R.id.mealaTitle)
        var description = view.findViewById<TextView>(R.id.mealsDescription)
        var image = view.findViewById<ImageView>(R.id.subImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SupViewHolder {
        return SupViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.sub_item ,parent , false))
    }

    override fun getItemCount(): Int {
        return response.size

    }

    override fun onBindViewHolder(holder: SupViewHolder, position: Int) {
//        holder.textS.text = subArray.get(position).categories.get(position).strCategory
        holder.title.text = response[position].strCategory
        holder.description.text = response[position].strCategoryDescription
        Glide.with(holder.itemView.rootView.context).load( response[position].strCategoryThumb).into(holder.image)

    }
}