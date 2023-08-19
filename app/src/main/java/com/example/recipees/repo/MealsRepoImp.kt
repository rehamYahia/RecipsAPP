package com.example.recipees.repo

import androidx.lifecycle.LiveData
import com.example.recipees.database.MealsDao
import com.example.recipees.model.*
import com.example.recipees.network.MealsApiServices

class MealsRepoImp(private val mealsApiServices: MealsApiServices, private val mealsDao: MealsDao) :MealsRepo {
    // remote
    override suspend fun getMealsFromRemote(): Response = mealsApiServices.getMeals()
    override suspend fun getMealFilter(category: String): MealFilter  = mealsApiServices.getFilterMeal(category)
    override suspend fun getLookupMeal(id: Int): MealsDetails =   mealsApiServices.getSpecificItem(id)

    //local

    override suspend fun insertMealToDatabase(category: Category) {
        mealsDao.insertMealsCategory(category)
    }
    override  fun mGetAllMealsFromDatabase(): LiveData<List<Category>> = mealsDao.getAllMealsOne()
    override suspend fun insertMealFilter(mealFilter: Meal , categoryName: NameCat) {
        mealsDao.insertMealFilter(mealFilter , categoryName)
    }

}