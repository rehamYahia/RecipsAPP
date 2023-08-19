package com.example.recipees.network

import com.example.recipees.model.MealFilter
import com.example.recipees.model.MealsDetails
import com.example.recipees.model.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MealsApiServices {
    @GET("categories.php")
    suspend fun getMeals() :Response

    @GET("filter.php")
    suspend fun getFilterMeal(@Query("c") category:String):MealFilter

    @GET("lookup.php")
    suspend fun getSpecificItem(@Query("i") id:Int) : MealsDetails
    //https://www.themealdb.com/api/json/v1/1/lookup.php?i=52982
}