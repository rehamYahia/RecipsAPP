package com.example.recipees.entities


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.Expose

//@TypeConverters(Converter::class)
//@Entity(tableName = "category")
data class Category(
//    @PrimaryKey(autoGenerate = true)
    val id:Int ,

//    @ColumnInfo(name ="categories" )
//    @Expose
//    @TypeConverters(Converter::class)
    val categories: List<CategoryItems>
)