package com.example.projectt.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "private_lesson")
data class PrivateLesson (
    @PrimaryKey var private_lesson_id: Int,
    var name: String,
    var price: Int,
    var address: String,
    var phoneNumber: String,
    var rating: Double)



