package com.example.recipees.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MealFilter(
    val meals: List<Meal>
){
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0
}