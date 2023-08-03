package com.example.recipees.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
 data class NameCat (val categoryName : String){
 @PrimaryKey(autoGenerate = true)
 var idd:Int = 0
 }