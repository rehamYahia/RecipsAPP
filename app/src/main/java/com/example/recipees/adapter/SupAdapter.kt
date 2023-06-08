package com.example.recipees.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recipees.R
import com.example.recipees.model.MealsData


class SupAdapter :RecyclerView.Adapter<SupAdapter.SupViewHolder>(){
   private var MealsArray:ArrayList<MealsData> = ArrayList()

   public fun setArray(arrData: ArrayList<MealsData>){
        MealsArray = arrData
    }
    class SupViewHolder (view: View) : RecyclerView.ViewHolder(view){

        var title = view.findViewById<TextView>(R.id.mealaTitle)
        var description = view.findViewById<TextView>(R.id.mealsDescription)
        var image = view.findViewById<ImageView>(R.id.subImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SupViewHolder {
        return SupViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.sub_item ,parent , false))
    }

    override fun getItemCount(): Int {
        return MealsArray.size

    }

    override fun onBindViewHolder(holder: SupViewHolder, position: Int) {
//        holder.textS.text = subArray.get(position).categories.get(position).strCategory
        holder.title.text = MealsArray[position].strCategory
        holder.description.text = MealsArray[position].strCategoryDescription
        Glide.with(holder.itemView.rootView.context).load( MealsArray[position].strCategoryThumb).into(holder.image)

    }
}