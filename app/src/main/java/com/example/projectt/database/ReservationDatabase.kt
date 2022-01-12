package com.example.projectt.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Reservation::class], version = 1, exportSchema = false)
abstract class ReservationDatabase: RoomDatabase() {
    abstract val reservationDao: ReservationDao

    companion object {

        @Volatile
        private var INSTANCE: ReservationDatabase? = null

        fun getInstance(context: Context): ReservationDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ReservationDatabase::class.java,
                        "renovation_database"
                    )
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}