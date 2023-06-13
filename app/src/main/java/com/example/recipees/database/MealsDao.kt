package com.example.recipees.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.recipees.model.Category
import kotlinx.coroutines.flow.StateFlow

@Dao
interface MealsDao {
    @Insert
    suspend fun insertMealsCategory(category: Category)
    @Query("SELECT * FROM MealsOne")
    suspend fun getAllMealsOne() : StateFlow<ArrayList<Category>>
}