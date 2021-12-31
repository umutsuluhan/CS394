package com.example.projectt.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Renovation::class], version = 4, exportSchema = false)
abstract class RenovationDatabase: RoomDatabase() {

    abstract val renovationDao: RenovationDao

    companion object {

        @Volatile
        private var INSTANCE: RenovationDatabase? = null

        fun getInstance(context: Context): RenovationDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        RenovationDatabase::class.java,
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