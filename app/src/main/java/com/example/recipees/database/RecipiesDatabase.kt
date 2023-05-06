package com.example.recipees.database

import androidx.activity.contextaware.ContextAware
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.recipees.dao.RecipesDao
import com.example.recipees.entities.Category
import com.example.recipees.entities.CategoryItems
import com.example.recipees.entities.Converter
import com.example.recipees.entities.Recipies
import com.tencent.wcdb.support.Context

//@Database(entities = [ Category::class , CategoryItems::class,Converter::class], version = 1 , exportSchema = false)
//@TypeConverters(Converter::class)
abstract class RecipiesDatabase :RoomDatabase(){

//    companion object{
//
//        private  var recipiesDatabase: RecipiesDatabase?=null
//
//        @Synchronized
//        fun databaseBuilder(context: Context): RecipiesDatabase
//        {
//            if(recipiesDatabase == null)
//            {
//                recipiesDatabase = Room.databaseBuilder<RecipiesDatabase>(
//                    context,
//                    RecipiesDatabase::class.java,
//                    "recipesdatabase.db"
//                ).fallbackToDestructiveMigration()
//                    .allowMainThreadQueries()
//                    .build()
//            }
//                return recipiesDatabase as RecipiesDatabase
//        }
//    }
//
//    abstract fun recipeDao():RecipesDao
}