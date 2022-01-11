package com.example.projectt.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "catering")
data class Catering (
    @PrimaryKey var catering_id: Int,
    var name: String,
    var price: Double,
    var address: String,
    var phoneNumber: String,
    var rating: Double
): Serializable