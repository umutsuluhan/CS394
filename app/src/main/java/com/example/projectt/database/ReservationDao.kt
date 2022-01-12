package com.example.projectt.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ReservationDao {
    @Insert
    fun insert(reservation: Reservation)

    @Insert
    fun insertAll(reservation: Reservation)

    @Update
    suspend fun update(reservation: Reservation)

    @Query("DELETE FROM reservation")
    fun clear()

    @Query("SELECT * FROM reservation")
    fun getAll(): List<Reservation>

    @Query("SELECT * FROM reservation")
    fun getAllReservations(): List<Reservation>
}