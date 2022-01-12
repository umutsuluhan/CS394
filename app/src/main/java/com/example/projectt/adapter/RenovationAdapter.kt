package com.example.projectt.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.projectt.database.Renovation
import com.example.projectt.databinding.RenovationItemBinding

class RenovationAdapter(val clickListener: RenovationListener): ListAdapter<Renovation, RenovationAdapter.ViewHolder>(RenovationDiffCallback()) {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position)!!, clickListener)

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(val binding: RenovationItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: Renovation, clickListener: RenovationListener){
           binding.renovation = item
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = RenovationItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)

            }
        }
    }

}

class RenovationDiffCallback : DiffUtil.ItemCallback<Renovation>() {

    override fun areItemsTheSame(oldItem: Renovation, newItem: Renovation): Boolean {
        return oldItem.renovation_id == newItem.renovation_id
    }


    override fun areContentsTheSame(oldItem: Renovation, newItem: Renovation): Boolean {
        return oldItem == newItem
    }


}

class RenovationListener(val clickListener: (renovationId: Int) -> Unit) {
    fun onClick(renovation: Renovation) = clickListener(renovation.renovation_id)
}