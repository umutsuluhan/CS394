package com.example.projectt.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [PrivateLesson::class], version = 5, exportSchema = false)
abstract class PrivateLessonDatabase: RoomDatabase() {

    abstract val privateLessonDao: PrivateLessonDao

    companion object{

        @Volatile
        private var INSTANCE: PrivateLessonDatabase? = null

        fun getInstance(context: Context): PrivateLessonDatabase {
            synchronized(this){
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        PrivateLessonDatabase::class.java,
                        "private_lesson_database"
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