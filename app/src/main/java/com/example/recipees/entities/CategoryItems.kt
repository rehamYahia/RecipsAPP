package com.example.recipees.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

//@Entity(tableName = "CategoryItems")
data class CategoryItems(
//    @PrimaryKey(autoGenerate = true)
    val id:Int ,


//    @ColumnInfo(name ="idCategory" )
//    @Expose
    val idCategory: String,

//    @ColumnInfo(name ="strCategory" )
//    @Expose
    val strCategory: String,

//    @ColumnInfo(name ="strCategoryDescription" )
//    @Expose
    val strCategoryDescription: String,

//    @ColumnInfo(name ="strCategoryThumb" )
//    @Expose
    val strCategoryThumb: String
)