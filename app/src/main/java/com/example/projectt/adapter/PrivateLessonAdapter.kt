package com.example.projectt.adapter


import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.projectt.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projectt.database.PrivateLesson

class PrivateLessonAdapter (val data: MutableList<PrivateLesson>): RecyclerView.Adapter<PrivateLessonAdapter.ViewHolder>() {

    /*var data =  listOf<PrivateLesson>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }*/

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    fun changeData(privateLessons: List<PrivateLesson>){
        data.clear()
        data.addAll(privateLessons)
    }

    class ViewHolder private constructor(itemView: View) : RecyclerView.ViewHolder(itemView){
        val name: TextView = itemView.findViewById(R.id.lesson_name)
        val address: TextView = itemView.findViewById(R.id.lesson_address)
        val price: TextView = itemView.findViewById(R.id.lesson_price)
        val rating: TextView = itemView.findViewById(R.id.lesson_rating)
        //val avatar: ImageView = itemView.findViewById(R.id.lesson_avatar)
        lateinit var item: PrivateLesson

        fun bind(item: PrivateLesson) {
            val res = itemView.context.resources
            this.item = item
            name.text = item.name
            address.text = item.address
            price.text = item.price.toString()
            rating.text = item.rating.toString()
            /*avatar.setImageResource(when (item.privateLesson) {
                0 -> R.drawable.ic_sleep_0
                1 -> R.drawable.ic_sleep_1
                2 -> R.drawable.ic_sleep_2
                3 -> R.drawable.ic_sleep_3
                4 -> R.drawable.ic_sleep_4
                5 -> R.drawable.ic_sleep_5
                else -> R.drawable.ic_sleep_active
            })*/
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater
                    .inflate(R.layout.private_lesson_item, parent, false)

                return ViewHolder(view)
            }
        }
    }
}