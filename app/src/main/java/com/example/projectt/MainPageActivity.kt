package com.example.projectt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
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

        findViewById<TextView>(R.id.textView2).text = user.toString()
    }
}