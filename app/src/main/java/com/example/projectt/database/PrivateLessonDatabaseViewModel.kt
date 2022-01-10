package com.example.projectt.database

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel

class PrivateLessonDatabaseViewModel( dataSource: PrivateLessonDao, application: Application):
    ViewModel() {
    val app = application
    private var privateLessonDao: PrivateLessonDao

    init {
        privateLessonDao = PrivateLessonDatabase.getInstance(application).privateLessonDao
    }

}