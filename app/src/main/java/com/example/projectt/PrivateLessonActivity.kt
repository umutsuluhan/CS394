package com.example.projectt

import androidx.appcompat.app.AppCompatActivity

class PrivateLessonActivity : AppCompatActivity() {

    public override fun onStart() {
        super.onStart()

        setContentView(R.layout.test)

        supportActionBar?.setDisplayShowHomeEnabled(true);
        supportActionBar?.setLogo(R.drawable.elma);
        supportActionBar?.setDisplayUseLogoEnabled(true);

    }
}