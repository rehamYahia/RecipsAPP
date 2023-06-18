package com.example.recipees.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
@Entity(tableName = "oneMealsTable")
data class MealOne (
    @PrimaryKey(autoGenerate = true)
    val id:Int,

    @Expose
    @SerializedName("idCategory")
    @ColumnInfo(name ="idCategory" )
    val idCategory: String,

    @Expose
    @SerializedName("strCategory")
    @ColumnInfo(name ="strCategory" )
    val strCategory: String,

    @Expose
    @SerializedName("strCategoryDescription")
    @ColumnInfo(name ="strCategoryDescription" )
    val strCategoryDescription: String,

    @Expose
    @SerializedName("strCategoryThumb")
    @ColumnInfo(name ="strCategoryThumb" )
    val strCategoryThumb: String
)