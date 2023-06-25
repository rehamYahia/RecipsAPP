package com.example.recipees.repo

import androidx.lifecycle.LiveData
import com.example.recipees.database.MealsDao
import com.example.recipees.model.Response
import com.example.recipees.network.MealsApiServices

class MealsRepoImp(private val mealsApiServices: MealsApiServices, private val mealsDao: MealsDao) :MealsRepo {
    override suspend fun getMealsFromRemote(): Response = mealsApiServices.getMeals()
    override suspend fun insertMealToDatabase(mealOne: MealOne) {
        mealsDao.insertMealsCategory(mealOne)

    }

    override  fun mGetAllMealsFromDatabase(): LiveData<List<MealOne>> = mealsDao.getAllMealsOne()
}