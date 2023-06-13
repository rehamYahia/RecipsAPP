package com.example.recipees.repo

import com.example.recipees.model.Category
import com.example.recipees.model.Response
import kotlinx.coroutines.flow.StateFlow

interface MealsRepo {

    suspend fun getMealsFromRemote():Response

    suspend fun insertMealToDatabase(category: Category)

    suspend fun mGetAllMealsFromDatabase(): StateFlow<ArrayList<Category>>
}