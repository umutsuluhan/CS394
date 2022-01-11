package com.example.projectt.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Catering::class], version = 7, exportSchema = false)
abstract class CateringDatabase: RoomDatabase() {

    abstract val cateringDao: CateringDao

    companion object{

        @Volatile
        private var INSTANCE: CateringDatabase? = null

        fun getInstance(context: Context): CateringDatabase {
            synchronized(this){
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        CateringDatabase::class.java,
                        "catering_database"
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