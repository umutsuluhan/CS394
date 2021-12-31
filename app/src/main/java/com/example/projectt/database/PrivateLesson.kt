package com.example.projectt.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "private_lesson")
data class PrivateLesson (
    @PrimaryKey(autoGenerate = true)
    var private_lesson_id: Int,
    var name: String,
    var city: String,
    var phoneNumber: String,
    var price: Int,
    var rating: Double,
    var photo: Int)



