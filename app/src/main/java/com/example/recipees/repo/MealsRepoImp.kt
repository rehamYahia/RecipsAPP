package com.example.recipees.repo

import androidx.lifecycle.LiveData
import com.example.recipees.database.MealsDao
import com.example.recipees.model.Category
import com.example.recipees.model.MealFilter
import com.example.recipees.model.Response
import com.example.recipees.network.MealsApiServices

class MealsRepoImp(private val mealsApiServices: MealsApiServices, private val mealsDao: MealsDao) :MealsRepo {
    override suspend fun getMealsFromRemote(): Response = mealsApiServices.getMeals()
    override suspend fun getMealFilter(category: String): MealFilter  = mealsApiServices.getFilterMeal(category)

    override suspend fun insertMealToDatabase(category: Category) {
        mealsDao.insertMealsCategory(category)
    }
    override  fun mGetAllMealsFromDatabase(): LiveData<List<Category>> = mealsDao.getAllMealsOne()
}