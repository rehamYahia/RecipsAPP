package com.example.recipees.repo

import com.example.recipees.database.EntityMeals
import com.example.recipees.database.MealOne
import com.example.recipees.model.Category
import com.example.recipees.model.Response


interface MealsRepo {

    suspend fun getMealsFromRemote():Response

    suspend fun insertMealToDatabase(mealOne: MealOne)

    suspend fun mGetAllMealsFromDatabase(): ArrayList<EntityMeals>
}