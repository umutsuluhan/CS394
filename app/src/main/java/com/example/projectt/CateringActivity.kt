package com.example.projectt

import androidx.appcompat.app.AppCompatActivity

class CateringActivity: AppCompatActivity() {

    public override fun onStart() {
        super.onStart()

        setContentView(R.layout.test)

        supportActionBar?.setDisplayShowHomeEnabled(true);
        supportActionBar?.setLogo(R.drawable.elma);
        supportActionBar?.setDisplayUseLogoEnabled(true);


        // DO EVERYTHING RELATED TO CATERING HERE
        // LAYOUT NAME IS TEST.XML FOR NOW. CREATE catering.xml and inflate that layout.

    }
}