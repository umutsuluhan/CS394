package com.example.projectt.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.projectt.database.Catering
import com.example.projectt.database.CateringDao
import com.example.projectt.database.CateringDatabase

class CateringViewModel(application: Application) : AndroidViewModel(application){
    private val _currentCatering = MutableLiveData<Catering>()
    val currentCatering: LiveData<Catering>
        get() = _currentCatering

    var usedCateringList: MutableList<Catering> = mutableListOf()
    lateinit var currentCatering1: Catering


    private val cateringDao = CateringDatabase.getInstance(application).cateringDao

    init {
        getNextCatering()
    }

    private fun getNextCatering(){
        val allCateringList = cateringDao.getAll()
        val randomNearbyCatering : Catering = allCateringList.random()

        currentCatering1 = randomNearbyCatering
        Log.d("getNextCatering", randomNearbyCatering.name)
        _currentCatering.value=randomNearbyCatering

        usedCateringList.add(currentCatering1)
    }

    fun nextCateringPage(){
        getNextCatering()
    }
}