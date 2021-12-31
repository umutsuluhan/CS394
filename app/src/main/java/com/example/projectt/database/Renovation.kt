package com.example.projectt.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "renovation")
data class Renovation (
    @PrimaryKey(autoGenerate = true)
    var name: String,
    var city: String,
    var phoneNumber: String,
    var rating: Double,
    var price: Int,
    var photo: Int)