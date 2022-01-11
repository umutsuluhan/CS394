package com.example.projectt

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projectt.adapter.PrivateLessonAdapter
import com.example.projectt.database.CateringDatabase
import com.example.projectt.database.PrivateLesson
import com.example.projectt.database.PrivateLessonDatabase
import com.example.projectt.databinding.PrivateLessonServicesBinding
import com.example.projectt.model.ItemCount

class PrivateLessonActivity : AppCompatActivity() {

/*    public override fun onStart() {
        super.onStart()

        setContentView(R.layout.test)

        supportActionBar?.setDisplayShowHomeEnabled(true);
        supportActionBar?.setLogo(R.drawable.elma);
        supportActionBar?.setDisplayUseLogoEnabled(true);
        val binding: PrivateLessonServicesBinding = DataBindingUtil.setContentView(this,R.layout.private_lesson_services)
        binding.privateLessonList.layoutManager = LinearLayoutManager(this)
        binding.privateLessonList.setHasFixedSize(true)
        var adapter = PrivateLessonAdapter(mutableListOf())
        binding.privateLessonList.adapter = adapter
    }*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.private_lesson_services)

    supportActionBar?.setDisplayShowHomeEnabled(true);
    supportActionBar?.setLogo(R.drawable.elma);
    supportActionBar?.setDisplayUseLogoEnabled(true);
    val binding: PrivateLessonServicesBinding = DataBindingUtil.setContentView(this,R.layout.private_lesson_services)

    val privateLessonDao = PrivateLessonDatabase.getInstance(application).privateLessonDao

    binding.privateLessonList.layoutManager = LinearLayoutManager(this)
    binding.privateLessonList.setHasFixedSize(true)
    var adapter = PrivateLessonAdapter(mutableListOf())

    val privateLessons :List<PrivateLesson>
    privateLessons = privateLessonDao.getAll()

    adapter.changeData(privateLessons)

    binding.privateLessonList.adapter = adapter


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