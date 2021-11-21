package com.example.projectt

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

class PrivateLessonServices : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.private_lesson_services, container, false)

        val lesson1 = PrivateLesson("Umut", "İstanbul", "05442225353", 150, 4.8, photo = R.drawable.avatar1)
        val lesson2 = PrivateLesson("İrem", "İstanbul", "05443215423", 170, 4.6, photo = R.drawable.avatar2)
        val lesson3 = PrivateLesson("Bora", "İstanbul", "05321214427", 140, 4.7, photo = R.drawable.avatar3)
        val lesson4 = PrivateLesson("Sefa", "Balıkesir", "05331224437", 140, 4.3, photo = R.drawable.avatar4)
        val lesson5 = PrivateLesson("Zeynep", "İstanbul", "05374172815", 180, 4.7, photo = R.drawable.avatar5)

        val list = arrayListOf<PrivateLesson>(lesson1, lesson2, lesson3, lesson4, lesson5)
        val viewAdapter = LessonAdapter(list)

        view.findViewById<RecyclerView>(R.id.private_lesson_list).run {
            setHasFixedSize(true)
            adapter = viewAdapter
        }

        return view;

    }
}

class LessonAdapter(private val data: ArrayList<PrivateLesson>): RecyclerView.Adapter<LessonAdapter.ViewHolder>(){

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view){
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.private_lesson_item, parent, false)

        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        viewHolder.view.findViewById<TextView>(R.id.name).text = data[position].name
        viewHolder.view.findViewById<TextView>(R.id.city).text = data[position].city
        viewHolder.view.findViewById<TextView>(R.id.rating).text = data[position].rating.toString()
        viewHolder.view.findViewById<TextView>(R.id.price).text = data[position].price.toString() + "TL/h"
        viewHolder.view.findViewById<ImageView>(R.id.profile_avatar).setImageResource(data[position].photo)


    }

    override fun getItemCount(): Int {
        return data.size
    }
}
