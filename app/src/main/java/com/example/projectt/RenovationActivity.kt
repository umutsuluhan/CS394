package com.example.projectt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projectt.adapter.PrivateLessonAdapter
import com.example.projectt.adapter.RenovationAdapter
import com.example.projectt.database.PrivateLesson
import com.example.projectt.database.PrivateLessonDatabase
import com.example.projectt.database.Renovation
import com.example.projectt.database.RenovationDatabase
import com.example.projectt.databinding.PrivateLessonServicesBinding
import com.example.projectt.databinding.RenovationServicesBinding

class RenovationActivity : AppCompatActivity() {

    /*public override fun onStart() {
        super.onStart()

        setContentView(R.layout.test)

        supportActionBar?.setDisplayShowHomeEnabled(true);
        supportActionBar?.setLogo(R.drawable.elma);
        supportActionBar?.setDisplayUseLogoEnabled(true);



    }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.private_lesson_services)

        supportActionBar?.setDisplayShowHomeEnabled(true);
        supportActionBar?.setLogo(R.drawable.elma);
        supportActionBar?.setDisplayUseLogoEnabled(true);
        val binding: RenovationServicesBinding = DataBindingUtil.setContentView(this,R.layout.renovation_services)

        val renovationDao = RenovationDatabase.getInstance(application).renovationDao

        binding.renovationList.layoutManager = LinearLayoutManager(this)
        binding.renovationList.setHasFixedSize(true)
        var adapter = RenovationAdapter(mutableListOf())

        val renovations :List<Renovation>
        renovations = renovationDao.getAll()

        adapter.changeData(renovations)

        binding.renovationList.adapter = adapter


        /*val plantDBViewModel:PlantDBViewModel by viewModels(){ PlantDBViewModelFactory(this.application) }
        plantDBViewModel.populateData()

        plantDBViewModel.fetchPlantsFromDB().observe(this, Observer<List<Plant>>{
                plants->plants?.let{
            //Log.d("Activity", "plant count ${plants.size}")
            if(plants.isNotEmpty()) {
                Log.d("Activity", "Plants swapped.")
                adapter.swapData(plants)
            }
        }
        }
        )*/
    }
}