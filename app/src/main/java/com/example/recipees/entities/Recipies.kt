package com.example.recipees.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

//@Entity(tableName = "recepiesTable")
data class Recipies (
//    @PrimaryKey(autoGenerate = true)
    val id:Int ,
    val name:String
    )//:java.io.Serializable