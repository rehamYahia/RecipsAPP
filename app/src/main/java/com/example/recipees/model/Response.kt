package com.example.recipees.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Response(
    val categories: List<Category>,
){
    @PrimaryKey(autoGenerate = true)
    var idddd:Int = 0
}