package com.example.recipees.database

import androidx.room.TypeConverter
import com.example.recipees.model.Category
import com.google.gson.Gson

class Converters {
    @TypeConverter
    public fun fromStringToList(stringMeal : String):ArrayList<Category>{
        return Gson().fromJson(stringMeal , ArrayList<Category>())
    }

    @TypeConverter
    public fun fromListToString(array:ArrayList<Category>):String{
        return Gson().toJson(array)
    }
}