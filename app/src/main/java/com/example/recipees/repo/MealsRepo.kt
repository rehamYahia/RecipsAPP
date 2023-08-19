package com.example.recipees.repo

import androidx.lifecycle.LiveData
import com.example.recipees.model.*


interface MealsRepo {

    //remote
    suspend fun getMealsFromRemote():Response

    suspend fun getMealFilter(category : String): MealFilter;

    suspend fun getLookupMeal(id:Int): MealsDetails

    //local
    suspend fun insertMealToDatabase(category: Category)
    fun mGetAllMealsFromDatabase(): LiveData<List<Category>>

    suspend fun insertMealFilter(mealFilter: Meal ,  categoryName: NameCat)


}