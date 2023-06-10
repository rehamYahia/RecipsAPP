package com.example.recipees.repo

import com.example.recipees.model.MealsData
import com.example.recipees.model.Response

interface MealsRepo {
    suspend fun getMealsFromRemote():Response
}