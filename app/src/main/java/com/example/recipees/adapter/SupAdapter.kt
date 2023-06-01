package com.example.recipees.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recipees.R
import com.example.recipees.entities.Category

class SupAdapter :RecyclerView.Adapter<SupAdapter.SupViewHolder>(){
    var subArray:ArrayList<Category> = ArrayList()

    fun setArray(arrData: List<Category>?){
        subArray = arrData as ArrayList<Category>
    }
    class SupViewHolder (view: View) : RecyclerView.ViewHolder(view){

//        var textS = itemView.findViewById<TextView>(R.id.textS)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SupViewHolder {
        return SupViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.sub_item ,parent , false))
    }

    override fun getItemCount(): Int {
        return subArray.size

    }

    override fun onBindViewHolder(holder: SupViewHolder, position: Int) {
//        holder.textS.text = subArray.get(position).categories.get(position).strCategory
    }
}