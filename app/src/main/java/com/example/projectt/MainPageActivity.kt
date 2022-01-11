package com.example.projectt

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.navigation.NavDeepLinkBuilder
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser


class MainPageActivity : AppCompatActivity() {


    public override fun onStart() {
        super.onStart()

        setContentView(R.layout.main_page)
        supportActionBar?.setDisplayShowHomeEnabled(true);
        supportActionBar?.setLogo(R.drawable.elma);
        supportActionBar?.setDisplayUseLogoEnabled(true);

        val firebaseAuth = FirebaseAuth.getInstance();
        val user = firebaseAuth.currentUser


    }

    fun navigateCatering(view: View){
        val switchActivityIntent = Intent(this, CateringActivity::class.java)
        startActivity(switchActivityIntent)
    }

    fun navigatePrivateLesson(view: android.view.View) {
        val switchActivityIntent = Intent(this, PrivateLessonActivity::class.java)
        startActivity(switchActivityIntent)
    }

    fun navigateRenovation(view: android.view.View) {
        val switchActivityIntent = Intent(this, RenovationActivity::class.java)
        startActivity(switchActivityIntent)
    }
}