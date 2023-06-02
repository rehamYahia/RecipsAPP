package com.example.recipees.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recipees.R
import com.example.recipees.model.MealsData


class SupAdapter :RecyclerView.Adapter<SupAdapter.SupViewHolder>(){
   private var MealsArray:ArrayList<MealsData> = ArrayList()

   public fun setArray(arrData: ArrayList<MealsData>){
        MealsArray = arrData
    }
    class SupViewHolder (view: View) : RecyclerView.ViewHolder(view){

        var title = itemView.findViewById<TextView>(R.id.mealaTitle)
        var description = itemView.findViewById<TextView>(R.id.mealsDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SupViewHolder {
        return SupViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.sub_item ,parent , false))
    }

    override fun getItemCount(): Int {
        return MealsArray.size

    }

    override fun onBindViewHolder(holder: SupViewHolder, position: Int) {
//        holder.textS.text = subArray.get(position).categories.get(position).strCategory
        holder.title.text = MealsArray.get(position).strCategory
        holder.description.text = MealsArray.get(position).strCategoryDescription
    }
}