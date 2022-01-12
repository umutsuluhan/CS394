package com.example.projectt.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import com.example.projectt.R
import com.google.firebase.auth.FirebaseAuth


class MainPageActivity : AppCompatActivity() {


    public override fun onStart() {
        super.onStart()

        setContentView(R.layout.main_page)
        supportActionBar?.setDisplayShowHomeEnabled(true);
        supportActionBar?.setLogo(R.drawable.elma);
        supportActionBar?.setDisplayUseLogoEnabled(true);

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