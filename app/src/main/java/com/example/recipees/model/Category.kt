package com.example.recipees.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


@Entity
data class Category(
    @PrimaryKey(autoGenerate = true)
    val idCategory: Int,
    val strCategory: String,  //forien1
    val strCategoryDescription: String,
    val strCategoryThumb: String
)