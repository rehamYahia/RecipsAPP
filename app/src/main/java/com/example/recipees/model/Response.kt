package com.example.recipees.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
//@Parcelize
 data class Response (
    val categories: List<Category>
)
//    : Parcelable
{
    @PrimaryKey(autoGenerate = true)
    var idddd: Int = 0
}