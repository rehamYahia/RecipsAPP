package com.example.recipees.database

import androidx.room.TypeConverter
import com.example.recipees.model.Category
import com.google.gson.Gson

class Converters {
    @TypeConverter
    public fun fromStringToCategory(stringMeal : String):Category{
        return Gson().fromJson(stringMeal , Category::class.java)
    }

    @TypeConverter
    public fun fromCategoryToString(category: Category):String{
        return Gson().toJson(category)
    }
}