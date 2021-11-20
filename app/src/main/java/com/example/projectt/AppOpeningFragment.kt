package com.example.projectt

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController

class AppOpeningFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_app_opening, container, false)

        view.findViewById<Button>(R.id.private_lesson_button).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_appOpeningFragment_to_privateLessonFragment2)
        }



        return view
    }

}