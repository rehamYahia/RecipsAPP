package com.example.recipees.network

import com.example.recipees.model.MealsData
import retrofit2.Retrofit
import retrofit2.http.GET

interface MealsApiServices {
    @GET("categories.php")
    suspend fun getMeals() :ArrayList<MealsData>
}