package com.example.projectt.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface CateringDao {
    @Insert
    suspend fun insert(catering: Catering)

    @Insert
    fun insertAll(catering: List<Catering>)

    @Update
    suspend  fun update(catering: Catering)

    @Query("DELETE FROM catering")
    fun clear()

    @Query("SELECT * FROM catering")
    fun getAll(): List<Catering>

    @Query("SELECT * FROM catering")
    fun getAllPlants(): List<Catering>
}