package com.example.recipees.database

import androidx.room.*
import com.example.recipees.model.Category
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "MealsTable")
data class EntityMeals (
    @Expose
    @SerializedName("categories")
    @TypeConverters(Converters::class)
    val categories: ArrayList<Category>,

    @PrimaryKey(autoGenerate = true)
    val id:Int
):Serializable