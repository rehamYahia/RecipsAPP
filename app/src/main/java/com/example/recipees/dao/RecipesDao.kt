package com.example.recipees.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.recipees.entities.Category
import com.example.recipees.entities.Recipies

@Dao
interface RecipesDao {
//    @get:Query("SELECT * FROM category ORDER BY id DESC")
//    val allRecipies : List<Category>
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun insertData(category: Category)
}