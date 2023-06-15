package com.example.recipees.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.recipees.model.Category

@Entity(tableName = "MealsOne" )
public   class ResponseTable (
    @PrimaryKey(autoGenerate = true)
    val id :Int,
    val category: ArrayList<Category>
)