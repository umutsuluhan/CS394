package com.example.projectt

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.projectt.databinding.ListItemLayoutBinding
import com.example.projectt.databinding.PrivateLessonServicesBinding
import com.example.projectt.viewmodel.CateringViewModel

class CateringActivity: AppCompatActivity() {
    private val viewModel: CateringViewModel by viewModels()


    public override fun onStart() {
        super.onStart()

        setContentView(R.layout.list_item_layout)

        supportActionBar?.setDisplayShowHomeEnabled(true);
        supportActionBar?.setLogo(R.drawable.elma);
        supportActionBar?.setDisplayUseLogoEnabled(true);


        // DO EVERYTHING RELATED TO CATERING HERE
        // LAYOUT NAME IS TEST.XML FOR NOW. CREATE catering.xml and inflate that layout.


        val binding: ListItemLayoutBinding =
            DataBindingUtil.setContentView(this, R.layout.list_item_layout)
        binding.cateringViewModel = viewModel

            binding.lifecycleOwner = this

        binding.CateringNextPageButton.setOnClickListener { nextPage() }

    }

    private fun nextPage(){
        viewModel.nextCateringPage()
    }
}