package com.example.recipees.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.recipees.model.Category
import com.example.recipees.model.Response


@Dao
interface MealsDao {
    @Insert
    suspend fun insertMealsCategory(category: Category)
    @Query("SELECT * FROM MealsOne")
    suspend fun getAllMealsOne() : Response
}