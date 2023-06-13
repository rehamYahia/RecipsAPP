package com.example.recipees.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.recipees.model.Category

@Database(entities = [Category::class] , version = 1)
abstract class MealsDatabase  :RoomDatabase(){

    abstract fun getDao():MealsDao

    companion object{
        private var INSTANCE :MealsDatabase ?= null
        fun getInstance(context: Context):MealsDatabase{
            if(INSTANCE == null){
                INSTANCE = Room.databaseBuilder<MealsDatabase>(
                    context.applicationContext , MealsDatabase::class.java , "mealDb"
                ).allowMainThreadQueries()
                    .build()
            }
            return INSTANCE as MealsDatabase
        }
    }

}