package com.example.recipees.repo

import com.example.recipees.database.EntityMeals
import com.example.recipees.database.MealOne
import com.example.recipees.database.MealsDao
import com.example.recipees.model.Category
import com.example.recipees.model.Response
import com.example.recipees.network.MealsApiServices
import kotlinx.coroutines.flow.StateFlow

class MealsRepoImp(private val mealsApiServices: MealsApiServices, private val mealsDao: MealsDao) :MealsRepo {
    override suspend fun getMealsFromRemote(): Response = mealsApiServices.getMeals()
    override suspend fun insertMealToDatabase(mealOne: MealOne) {
        mealsDao.insertMealsCategory(mealOne)

    }

    override suspend fun mGetAllMealsFromDatabase(): ArrayList<EntityMeals> = mealsDao.allMeals
}