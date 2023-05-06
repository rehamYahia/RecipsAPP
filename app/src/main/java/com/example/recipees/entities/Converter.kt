package com.example.recipees.entities

import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converter {
//    @TypeConverter
//    fun fromCategoriesToString(categories :List<CategoryItems>?):String{
//            return Gson().toJson(categories)
//    }
//
//    @TypeConverter
//    fun fromStringToCategories(catString:String?):List<CategoryItems>{
//            val type = object :TypeToken<List<CategoryItems>>(){}.type
//            return Gson().fromJson(catString, type)
//    }


//    @TypeConverter
//    fun fromCategoriesToString(categories : List<Category>?):String?{
//        if(categories == null){
//            return (null)
//        }
//        else{
//            val type = object:TypeToken<Category>(){}.type
//            return Gson().toJson(categories , type)
//        }
//    }
//
//    @TypeConverter
//    fun fromStringToCategories(catString:String?):List<Category>?{
//        if(catString == null){
//            return (null)
//        }else{
//            val type = object : TypeToken<Category>(){}.type
//            return Gson().fromJson(catString , type)
//        }
//
//    }


}