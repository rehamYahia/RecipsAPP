package com.example.recipees.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.recipees.entities.Category
import com.example.recipees.entities.CategoryItems
import com.tencent.wcdb.support.Context


//@Database(entities = [CategoryItems::class , Category::class] , version = 1)
abstract class MealDatabase :RoomDatabase(){

//    companion object{
//        private var mealDatabase : MealDatabase?=null
//        fun getInstanceFromDatabase (context:Context): MealDatabase{
//            if(mealDatabase == null){
//                mealDatabase = Room.databaseBuilder()
//
//            }
//        }
//
//    }
}