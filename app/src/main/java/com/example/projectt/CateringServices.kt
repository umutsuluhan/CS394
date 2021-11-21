package com.example.projectt

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projectt.adapter.ItemListAdapter
import com.example.projectt.data.Datasource
import com.example.projectt.databinding.CateringServicesBinding
import com.example.projectt.model.ItemCount

class CateringServices : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding = DataBindingUtil.inflate<CateringServicesBinding>(inflater, R.layout.catering_services, container,false)

        val myDataset = Datasource().loadListItems()
        val rv = binding.rv
        rv.adapter = ItemListAdapter(myDataset)
        rv.setHasFixedSize(true)
        val dataBinding = ItemCount("Available Catering Companies",myDataset.size)
        binding.countItem = dataBinding
        return binding.root;

    }
}