package com.example.recipees.model

import androidx.room.Entity
import androidx.room.PrimaryKey

//@Entity(tableName = "first")
data class Category(
//    @PrimaryKey(autoGenerate = false)
    val idCategory: String,
    val strCategory: String,
    val strCategoryDescription: String,
    val strCategoryThumb: String
)