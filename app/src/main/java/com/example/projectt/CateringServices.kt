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

class CateringServices : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.catering_services, container, false)

        val myDataset = Datasource().loadListItems()
        val rv = view.findViewById<RecyclerView>(R.id.rv)
        rv.layoutManager = LinearLayoutManager(view.context)
        rv.adapter = ItemListAdapter(myDataset)
        rv.setHasFixedSize(true)

        return view;

    }
}