package com.example.recipees.network

import com.example.recipees.model.Response
import retrofit2.http.GET

interface MealsApiServices {
    @GET("categories.php")
    suspend fun getMeals() :Response
}