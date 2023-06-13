package com.example.recipees.repo

import com.example.recipees.model.Category
import com.example.recipees.model.Response

interface MealsRepo {

    suspend fun getMealsFromRemote():Response

    suspend fun insertMealToDatabase()

    suspend fun GetAllMealsFromDatabase():ArrayList<Category>
}