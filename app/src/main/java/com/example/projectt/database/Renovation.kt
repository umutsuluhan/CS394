package com.example.projectt.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "renovation")
data class Renovation (
    @PrimaryKey var renovation_id: Int,
    var name: String,
    var price: Int,
    var address: String,
    var phoneNumber: String,
    var rating: Double)