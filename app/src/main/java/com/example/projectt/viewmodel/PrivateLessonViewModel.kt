package com.example.projectt.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import com.example.projectt.database.PrivateLessonDao

class PrivateLessonViewModel (dataSource: PrivateLessonDao, application: Application): ViewModel(){
    val database = dataSource
    val privateLessons = database.getAll()

}