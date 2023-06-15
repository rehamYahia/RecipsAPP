package com.example.recipees.repo

import com.example.recipees.database.ResponseTable
import com.example.recipees.model.Category
import com.example.recipees.model.Response


interface MealsRepo {

    suspend fun getMealsFromRemote():Response

    suspend fun insertMealToDatabase(category: Category)

    suspend fun mGetAllMealsFromDatabase(): ResponseTable
}