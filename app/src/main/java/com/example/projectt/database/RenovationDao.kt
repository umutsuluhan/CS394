package com.example.projectt.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface RenovationDao {
    @Insert
    suspend fun insert(renovation: Renovation)

    @Insert
    fun insertAll(renovations: List<Renovation>)

    @Update
    suspend  fun update(renovation: Renovation)

    @Query("DELETE FROM renovation")
    fun clear()

    @Query("SELECT * FROM renovation")
    fun getAll(): List<Renovation>

    @Query("SELECT * FROM renovation")
    fun getAllPlants(): List<Renovation>


}