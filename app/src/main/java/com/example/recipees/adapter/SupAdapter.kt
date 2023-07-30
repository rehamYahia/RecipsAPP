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
import com.example.recipees.model.Meal


class SupAdapter() :RecyclerView.Adapter<SupAdapter.SupViewHolder>(){
    private var   list:List<Meal> = java.util.ArrayList()
//    private var   meal:List<Category> = java.util.ArrayList()
    public fun setData(arr:List<Meal>){
        list = arr
    }
//    public fun setDataFromLocalDb(meals:List<Category>){
//        meal = meals
//    }

    class SupViewHolder (view: View) : RecyclerView.ViewHolder(view){

        var title = view.findViewById<TextView>(R.id.mealaTitle)
//        var description = view.findViewById<TextView>(R.id.mealsDescription)
        var image = view.findViewById<ImageView>(R.id.subImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SupViewHolder {
        return SupViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.sub_item ,parent , false))
    }

    override fun getItemCount(): Int {
        return list.size

    }

    override fun onBindViewHolder(holder: SupViewHolder, position: Int) {
        holder.title.text = list[position].strMeal
//        holder.description.text = list[position].
        Glide.with(holder.itemView.rootView.context).load( list[position].strMealThumb).into(holder.image)

    }
}