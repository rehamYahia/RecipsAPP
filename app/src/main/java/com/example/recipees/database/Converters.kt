package com.example.recipees.database

import androidx.room.TypeConverter
import com.example.recipees.model.Category
import com.google.gson.Gson

class Converters {
//    @TypeConverter
//    public fun fromStringToCategory(stringMeal : String):Category{
//        return Gson().fromJson(stringMeal , Category::class.java)
//    }
//
//    @TypeConverter
//    public fun fromCategoryToString(category: Category):String{
//        return Gson().toJson(category)
//    }

    @TypeConverter
    public fun fromStringToList(string :String):ArrayList<Category>{
       val listType:Type = TypeToken<ArrayList<Category>>{}.getType()
       return Gson().fromJson(string ,listType)
    }

    @TypeConverter
    public fun fromListToString(list:ArrayList<Category>) : String{
        val gson :Gson = Gson()
        val json:String = gson.toJson(list)
        return json
    }
}