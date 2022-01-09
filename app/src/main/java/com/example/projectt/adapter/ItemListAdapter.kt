package com.example.projectt.adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projectt.model.ListItem
import com.example.projectt.R


class ItemListAdapter(
    private val dataset: List<ListItem>
) : RecyclerView.Adapter<ItemListAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val LIST_ITEM_KEY = "LIST_ITEM"
        val textView: TextView = view.findViewById(R.id.list_item_title)
        val addressTextView: TextView = view.findViewById(R.id.list_item_address_title)
        lateinit var listItem:ListItem

        fun bindListItem(listItem:ListItem){
            this.listItem = listItem
            val context = itemView.getContext()
            textView.text = context.resources.getString(listItem.stringResourceId)
            addressTextView.text = context.resources.getString(listItem.stringResourceAddressId)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_layout, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }


    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val listItem = dataset[position]
        holder.bindListItem(listItem)

    }


}