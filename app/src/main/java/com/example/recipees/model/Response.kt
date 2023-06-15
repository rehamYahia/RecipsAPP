package com.example.recipees.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "MealsOne"  )
data class Response(
    val categories: ArrayList<Category>,
    @PrimaryKey(autoGenerate = true)
    val id:Int
)