package com.example.recipees.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recipees.R
import com.example.recipees.entities.Recipies

class MainAdapter : RecyclerView.Adapter<MainAdapter.MainViewHolder> {
    var mainArray : ArrayList<Recipies> = ArrayList()

//    fun setData(arrData : List<Recipies>){
//        mainArray = arrData as ArrayList<Recipies>
//    }

    constructor(conArray:ArrayList<Recipies>){
        this.mainArray = conArray
    }

    class MainViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var textM = itemView.findViewById<TextView>(R.id.textM)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.main_item , parent , false))
    }

    override fun getItemCount(): Int {
        return mainArray.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.textM.text = mainArray.get(position).name
    }
}