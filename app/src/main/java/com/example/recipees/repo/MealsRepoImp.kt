package com.example.recipees.repo

import com.example.recipees.model.MealsData
import com.example.recipees.model.Response
import com.example.recipees.network.MealsApiServices

class MealsRepoImp(private val mealsApiServices: MealsApiServices) :MealsRepo {
    override suspend fun getMealsFromRemote(): Response = mealsApiServices.getMeals()
}