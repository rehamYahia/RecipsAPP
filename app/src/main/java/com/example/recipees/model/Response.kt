package com.example.recipees.model

import androidx.room.Entity
import androidx.room.TypeConverters

@Entity(tableName = "MealsOne" )
data class Response(
    @TypeConverters
    val categories: ArrayList<Category>
)