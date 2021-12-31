package com.example.projectt.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "catering")
data class Catering (
    @PrimaryKey(autoGenerate = true)
    var catering_id: Int,
    var name: String,
    var price: Double,
    var address: String
)