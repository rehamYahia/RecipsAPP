package com.example.recipees.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.recipees.model.Category
import com.example.recipees.model.Response


@Dao
interface MealsDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertMealsCategory(category: Category)

    @Query ("SELECT * FROM Category")
     fun getAllMealsOne() : LiveData<List<Category>>

}