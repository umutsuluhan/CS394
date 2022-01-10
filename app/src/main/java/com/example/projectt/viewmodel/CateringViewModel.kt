package com.example.projectt.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.projectt.database.Catering
import com.example.projectt.database.CateringDao

class CateringViewModel : ViewModel(){
    private val _currentCatering = MutableLiveData<Catering>()
    val currentCatering: LiveData<Catering>
        get() = _currentCatering

    private var usedCateringList: MutableList<Catering> = mutableListOf()
    private lateinit var currentCatering1: Catering

    init {
        getNextCatering()
    }

    private fun getNextCatering(){
        var allCateringList = listOf(
                Catering(1, "n1", 1.1,  "A1",  "33", 2.2),
                Catering(2,"n2",  2.2,  "A2",  "66", 4.4),
                Catering(3,"n3",3.3,  "A3",  "99", 8.8),
                Catering(4,"n4", 4.4,  "A4",  "22", 16.16),
                Catering(5,"n5", 5.5,  "A5",  "55", 32.32)
            )
        /*allCateringList = CateringDao.getAll()*/
        val randomNearbyCatering : Catering = allCateringList.random()

        currentCatering1 = randomNearbyCatering
        Log.d("getNextCatering", randomNearbyCatering.name)
        _currentCatering.value=randomNearbyCatering

        usedCateringList.add(currentCatering1)
    }
    fun reinitializeData() {
        usedCateringList.clear()
        getNextCatering()
    }
    fun nextCateringPage(){
        getNextCatering()
    }
}