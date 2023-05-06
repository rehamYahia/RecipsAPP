package com.example.recipees.network

import com.example.recipees.entities.Category
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET

interface RecipiesApiServices  {
    @GET("categories.php")
    fun getAllRecipies():Call<List<Category>>
}