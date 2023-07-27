package com.example.recipees.database

import androidx.room.TypeConverter
import com.example.recipees.model.Category
import com.example.recipees.model.Response
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
    public fun fromStringToList1(string :String): List<Category>? {
        val gson = Gson()
        val type = object :TypeToken<Category>(){
        }.type
        return gson.fromJson(string,type)
    }
//    @TypeConverter
//    public fun fromListToString(response: Response) : String? {
//        val gson = Gson()
//        val type = object :TypeToken<Response>(){
//        }.type
//        return gson.toJson(response,type)
//    }
//
//    @TypeConverter
//    public fun fromStringToList(string :String): Response {
//        val gson = Gson()
//        val type = object :TypeToken<Response>(){
//        }.type
//        return gson.fromJson(string,type)
//    }




//    @TypeConverter
//    public fun fromStringToList(string :String):ArrayList<Category>{
//       val listType = object :TypeToken<ArrayList<Category>>(){}.type
//       return Gson().fromJson(string ,listType)
//    }
//
//    @TypeConverter
//    public fun fromListToString(list:ArrayList<Category>) : String{
////        val gson :Gson = Gson()
////        val json:String = gson.toJson(list)
//        return Gson().toJson(list)
//    }
//
//    @TypeConverter
//    public fun fromCategoryToString(list:Category) : String{
////        val gson :Gson = Gson()
////        val json:String = gson.toJson(list)
//        return Gson().toJson(list)
//    }
//
//    @TypeConverter
//    public fun fromStringToCategory(string :String):Category{
//        val listType = object :TypeToken<Category>(){}.type
//        return Gson().fromJson(string ,listType)
//    }

}
