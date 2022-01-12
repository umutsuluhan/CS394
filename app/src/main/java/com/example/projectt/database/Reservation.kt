package com.example.projectt.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "reservation")
data class Reservation (
    @PrimaryKey
    var reservation_id: Int,
    var mail: String,
    var name: String,
)
