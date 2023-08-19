package com.example.recipees.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recipees.R
import com.example.recipees.model.Category
import com.example.recipees.model.Meal
import com.example.recipees.ui.HomeFragmentDirections


class SupAdapter() :RecyclerView.Adapter<SupAdapter.SupViewHolder>(){
    private var   list:List<Meal> = java.util.ArrayList()

    public fun setData(arr:List<Meal>){
        list = arr
    }


    class SupViewHolder (view: View) : RecyclerView.ViewHolder(view){

        var title: TextView = view.findViewById<TextView>(R.id.mealaTitle)
//        var description = view.findViewById<TextView>(R.id.mealsDescription)
        var image: ImageView = view.findViewById<ImageView>(R.id.subImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SupViewHolder {
        return SupViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.sub_item ,parent , false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: SupViewHolder, position: Int) {
        holder.title.text = list[position].strMeal
        Glide.with(holder.itemView.rootView.context).load( list[position].strMealThumb).into(holder.image)
        holder.itemView.setOnClickListener {
            val meal :Meal = list[position]
            val mealId :Int = list[position].idMeal.toInt()
            val action =  HomeFragmentDirections.actionHomeFragmentToDetailFragment(meal, mealId)
            Navigation.findNavController(it).navigate(action)
        }
    }
}