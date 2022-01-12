package com.example.projectt.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.projectt.database.PrivateLesson
import com.example.projectt.databinding.PrivateLessonItemBinding

class PrivateLessonAdapter(val clickListener: PrivateLessonListener) : ListAdapter<PrivateLesson, PrivateLessonAdapter.ViewHolder>(PrivateLessonDiffCallback()) {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position)!!, clickListener)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(val binding: PrivateLessonItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: PrivateLesson, clickListener: PrivateLessonListener){
            binding.privateLesson = item
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = PrivateLessonItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)

            }
        }
    }
}

class PrivateLessonDiffCallback : DiffUtil.ItemCallback<PrivateLesson>() {

    override fun areItemsTheSame(oldItem: PrivateLesson, newItem: PrivateLesson): Boolean {
        return oldItem.private_lesson_id == newItem.private_lesson_id
    }


    override fun areContentsTheSame(oldItem: PrivateLesson, newItem: PrivateLesson): Boolean {
        return oldItem == newItem
    }
}

class PrivateLessonListener(val clickListener: (privateLessonId: Int) -> Unit) {
    fun onClick(privateLesson: PrivateLesson) = clickListener(privateLesson.private_lesson_id)
}

