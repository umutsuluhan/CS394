package com.example.projectt.activities

import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.projectt.R
import com.example.projectt.databinding.ListItemLayoutBinding
import com.example.projectt.viewmodel.CateringViewModel

class CateringActivity: AppCompatActivity() {
    private val viewModel: CateringViewModel by viewModels()


    public override fun onStart() {
        super.onStart()

        setContentView(R.layout.list_item_layout)

        supportActionBar?.setDisplayShowHomeEnabled(true);
        supportActionBar?.setLogo(R.drawable.elma);
        supportActionBar?.setDisplayUseLogoEnabled(true);

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