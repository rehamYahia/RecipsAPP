package com.example.recipees.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.recipees.model.Category
import com.example.recipees.model.Response


@Dao
interface MealsDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertMealsCategory(mealOne: MealOne)

    @get:Query ("SELECT * FROM MealsTable ORDER BY id DESC")
    val allMeals:ArrayList<EntityMeals>
//    suspend fun getAllMealsOne() : Response
}