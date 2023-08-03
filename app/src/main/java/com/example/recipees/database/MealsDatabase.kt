package com.example.recipees.database

import android.content.Context
import androidx.room.*
import com.example.recipees.model.*

@Database(entities = [Category::class , Response::class , Meal::class , MealFilter::class , NameCat::class] , version = 1 , exportSchema = false)
@TypeConverters(Converters::class)
abstract class MealsDatabase  :RoomDatabase(){
    abstract fun getDao():MealsDao

}