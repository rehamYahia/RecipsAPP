package com.example.recipees.database

import androidx.room.TypeConverter
import com.example.recipees.model.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {

    @TypeConverter
    public fun fromListToString1(category:List<Category>) : String? {
        val gson = Gson()
        val type = object :TypeToken<Category>(){
        }.type
        return gson.toJson(category,type)
    }

    @TypeConverter
    public fun fromStringToList2(string :String): List<Category>? {
        val gson = Gson()
        val type = object :TypeToken<Category>(){
        }.type
        return gson.fromJson(string,type)
    }

    @TypeConverter
    public fun fromListToString2(meals:List<Meal>) : String? {
        val gson = Gson()
        val type = object :TypeToken<Meal>(){
        }.type
        return gson.toJson(meals,type)
    }

    @TypeConverter
    public fun fromStringToList1(string :String): List<Meal>? {
        val gson = Gson()
        val type = object :TypeToken<Meal>(){
        }.type
        return gson.fromJson(string,type)
    }

    @TypeConverter
    public fun fromObjectToString(mealFilter:MealFilter) : String? {
        val gson = Gson()
        val type = object :TypeToken<Meal>(){
        }.type
        return gson.toJson(mealFilter,type)
    }

    @TypeConverter
    public fun fromStringToObject(string :String): MealFilter? {
        val gson = Gson()
        val type = object :TypeToken<MealFilter>(){
        }.type
        return gson.fromJson(string,type)
    }


    @TypeConverter
    public fun fromCatNameToString1(category: NameCat) : String? {
        val gson = Gson()
        val type = object :TypeToken<NameCat>(){
        }.type
        return gson.toJson(category,type)
    }

    @TypeConverter
    public fun fromStringToCatName(string :String): NameCat? {
        val gson = Gson()
        val type = object :TypeToken<NameCat>(){
        }.type
        return gson.fromJson(string,type)
    }


}
