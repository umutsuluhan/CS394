package com.example.projectt

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

class RenovationServices: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.renovation_services, container, false)

        val renovation1 = Renovation("Egemen Renovation", "İstanbul", "08501235252", 4.8 , 15000, photo = R.drawable.renovation1)
        val renovation2 = Renovation("Borusan Renovation", "İstanbul", "08504122133",4.6 , 12000, photo = R.drawable.renovation2)
        val renovation3 = Renovation("Extreme Renovation", "Tekirdağ", "0850452789",4.9 , 8000, photo = R.drawable.renovation3)
        val renovation4 = Renovation("Zirve Renovation", "Çanakkale", "08504753269",4.6 , 10000, photo = R.drawable.renovation4)
        val renovation5 = Renovation("Emek Renovation", "İstanbul", "0850951123",4.7 , 9000, photo = R.drawable.renovation5)
        val renovation6 = Renovation("Octet Renovation", "Balıkesir", "0850709709",4.1 , 7000, photo = R.drawable.renovation6)


        val list = arrayListOf<Renovation>(renovation1, renovation2, renovation3,renovation4,renovation5,renovation6)

        val viewAdapter = RenovationAdapter(list)

        view.findViewById<RecyclerView>(R.id.renovation_list).run {
            setHasFixedSize(true)
            adapter = viewAdapter
        }

        return view;
    }
}

class RenovationAdapter(private val data: ArrayList<Renovation>): RecyclerView.Adapter<RenovationAdapter.ViewHolder>(){

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view){
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.renovation_item, parent, false)

        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        viewHolder.view.findViewById<TextView>(R.id.renovation_name).text = data[position].name
        viewHolder.view.findViewById<TextView>(R.id.renovation_city).text = data[position].city
        viewHolder.view.findViewById<TextView>(R.id.renovation_rating).text = data[position].rating.toString()
        viewHolder.view.findViewById<TextView>(R.id.renovation_price).text = data[position].price.toString() + "TL/h"
        viewHolder.view.findViewById<ImageView>(R.id.renovation_profile_avatar).setImageResource(data[position].photo)


    }

    override fun getItemCount(): Int {
        return data.size
    }
}