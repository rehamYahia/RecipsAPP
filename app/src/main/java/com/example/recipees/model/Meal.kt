package com.example.recipees.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class Meal(
    @PrimaryKey
    val idMeal: String,
    val strMeal: String,
    val strMealThumb: String
): Parcelable