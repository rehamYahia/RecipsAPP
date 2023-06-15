package com.example.recipees.repo

import com.example.recipees.database.MealsDao
import com.example.recipees.model.Category
import com.example.recipees.model.Response
import com.example.recipees.network.MealsApiServices
import kotlinx.coroutines.flow.StateFlow

class MealsRepoImp(private val mealsApiServices: MealsApiServices, private val mealsDao: MealsDao) :MealsRepo {
    override suspend fun getMealsFromRemote(): Response = mealsApiServices.getMeals()
    override suspend fun insertMealToDatabase(category: Category) {
        mealsDao.insertMealsCategory(category)

    }

    override suspend fun mGetAllMealsFromDatabase(): ResponseTable = mealsDao.getAllMealsOne()
}