package com.example.recipees.repo

import com.example.recipees.model.MealsData

interface MealsRepo {
    suspend fun getMealsFromRemote():ArrayList<MealsData>
}