package com.example.recipees.repo

import androidx.lifecycle.LiveData
import com.example.recipees.model.Category
import com.example.recipees.model.MealFilter
import com.example.recipees.model.Response


interface MealsRepo {

    suspend fun getMealsFromRemote():Response

    suspend fun getMealFilter(category : String): MealFilter;
    suspend fun insertMealToDatabase(category: Category)
    fun mGetAllMealsFromDatabase(): LiveData<List<Category>>
}