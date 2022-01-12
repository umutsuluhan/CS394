package com.example.projectt.activities

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projectt.R
import com.example.projectt.adapter.PrivateLessonAdapter
import com.example.projectt.adapter.PrivateLessonListener
import com.example.projectt.database.PrivateLesson
import com.example.projectt.database.PrivateLessonDatabase
import com.example.projectt.database.Reservation
import com.example.projectt.database.ReservationDatabase
import com.example.projectt.databinding.PrivateLessonServicesBinding
import com.example.projectt.model.ItemCount
import com.google.firebase.auth.FirebaseAuth

class PrivateLessonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.private_lesson_services)

    supportActionBar?.setDisplayShowHomeEnabled(true);
    supportActionBar?.setLogo(R.drawable.elma);
    supportActionBar?.setDisplayUseLogoEnabled(true);
    val binding: PrivateLessonServicesBinding = DataBindingUtil.setContentView(this,
        R.layout.private_lesson_services
    )

    val privateLessonDao = PrivateLessonDatabase.getInstance(application).privateLessonDao
        val reservationDao = ReservationDatabase.getInstance(application).reservationDao

        binding.privateLessonList.layoutManager = LinearLayoutManager(this)
    binding.privateLessonList.setHasFixedSize(true)

        val firebaseAuth = FirebaseAuth.getInstance();

    var adapter = PrivateLessonAdapter(PrivateLessonListener { privateLessonId ->
        val reservation = Reservation( privateLessonId, firebaseAuth.currentUser?.email.toString(), privateLessonDao.getPrivateLesson(privateLessonId).get(0).name)
        reservationDao.insert(reservation)
    })

        Log.d("Reservation Database", reservationDao.getAll().toString())

    val privateLessons :List<PrivateLesson>
    privateLessons = privateLessonDao.getAll()
    adapter.submitList(privateLessons)

    binding.privateLessonList.adapter = adapter

    binding.countItem = ItemCount("Available Private Lessons",adapter.itemCount)
    }
}