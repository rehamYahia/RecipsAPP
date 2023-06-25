package com.example.recipees.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Response(
    val categories: ArrayList<Category>,
)