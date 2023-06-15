package com.example.recipees.database

import android.content.Context
import androidx.room.*
import com.example.recipees.model.Category
import com.example.recipees.model.Response

@Database(entities = [ResponseTable::class] , version = 1 , exportSchema = false)
@TypeConverters(Converters::class)
abstract class MealsDatabase  :RoomDatabase(){

    abstract fun getDao():MealsDao

    companion object{
        private var INSTANCE :MealsDatabase ?= null
        fun getInstance(context: Context):MealsDatabase{
            if(INSTANCE == null){
                INSTANCE = Room.databaseBuilder<MealsDatabase>(
                    context.applicationContext , MealsDatabase::class.java , "mealDb"
                ).allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return INSTANCE as MealsDatabase
        }
    }

}