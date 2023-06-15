package com.example.recipees.database

import androidx.room.TypeConverter
import com.example.recipees.model.Category
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class Converters {


    @TypeConverter
    public fun fromStringToList(string :String):ArrayList<Category>{
       val listType = object :TypeToken<ArrayList<Category>>(){}.type
       return Gson().fromJson(string ,listType)
    }

    @TypeConverter
    public fun fromListToString(list:ArrayList<Category>) : String{
//        val gson :Gson = Gson()
//        val json:String = gson.toJson(list)
        return Gson().toJson(list)
    }

    @TypeConverter
    public fun fromCategoryToString(list:Category) : String{
//        val gson :Gson = Gson()
//        val json:String = gson.toJson(list)
        return Gson().toJson(list)
    }

    @TypeConverter
    public fun fromStringToCategory(string :String):Category{
        val listType = object :TypeToken<Category>(){}.type
        return Gson().fromJson(string ,listType)
    }

}
