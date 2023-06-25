package com.example.recipees.repo

import androidx.lifecycle.LiveData
import com.example.recipees.model.Response


interface MealsRepo {

    suspend fun getMealsFromRemote():Response

    suspend fun insertMealToDatabase(mealOne: MealOne)

     fun mGetAllMealsFromDatabase(): LiveData<List<MealOne>>
}