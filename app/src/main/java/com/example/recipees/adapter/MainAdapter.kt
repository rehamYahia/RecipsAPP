package com.example.recipees.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recipees.R


class MainAdapter : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
//    var mainArray : ArrayList<Category> = ArrayList()
//
//    fun setData(arrData: List<Category>?){
//        mainArray = arrData as ArrayList<Category>
//    }



    class MainViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var textM = itemView.findViewById<TextView>(R.id.textM)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.main_item , parent , false))
    }

    override fun getItemCount(): Int {
//        return mainArray.size
        return 1
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
//        holder.textM.text = mainArray.get(position).categories.get(position).strCategory
    }
}