package com.example.projectt.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projectt.R
import com.example.projectt.adapter.RenovationAdapter
import com.example.projectt.adapter.RenovationListener
import com.example.projectt.database.Renovation
import com.example.projectt.database.RenovationDatabase
import com.example.projectt.databinding.RenovationServicesBinding
import com.example.projectt.model.ItemCount

class RenovationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.private_lesson_services)

        supportActionBar?.setDisplayShowHomeEnabled(true);
        supportActionBar?.setLogo(R.drawable.elma);
        supportActionBar?.setDisplayUseLogoEnabled(true);
        val binding: RenovationServicesBinding = DataBindingUtil.setContentView(this,
            R.layout.renovation_services
        )

        val renovationDao = RenovationDatabase.getInstance(application).renovationDao

        binding.renovationList.layoutManager = LinearLayoutManager(this)
        binding.renovationList.setHasFixedSize(true)
        var adapter = RenovationAdapter(RenovationListener { renovationId ->
            Toast.makeText(this.applicationContext, "Id: ${renovationId}", Toast.LENGTH_LONG).show()

        })


        val renovations :List<Renovation>
        renovations = renovationDao.getAll()

        adapter.submitList(renovations)

        binding.renovationList.adapter = adapter

        binding.countItem = ItemCount("Available Renovation Companies",adapter.itemCount)
    }
}