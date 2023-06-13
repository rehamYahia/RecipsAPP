package com.example.recipees.repo

import com.example.recipees.database.MealsDao
import com.example.recipees.model.Category
import com.example.recipees.model.Response
import com.example.recipees.network.MealsApiServices

class MealsRepoImp(private val mealsApiServices: MealsApiServices, private val mealsDao: MealsDao) :MealsRepo {
    override suspend fun getMealsFromRemote(): Response = mealsApiServices.getMeals()
    override suspend fun insertMealToDatabase() {
        val list = mealsApiServices.getMeals().categories
        for (i in list){
            mealsDao.insertMealsCategory(i)
        }
    }

    override suspend fun GetAllMealsFromDatabase(): ArrayList<Category>  = mealsDao.getAllMealsOne()
}