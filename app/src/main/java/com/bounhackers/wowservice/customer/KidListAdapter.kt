package com.bounhackers.wowservice.customer

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bounhackers.wowservice.R
import com.bounhackers.wowservice.data.Model
import kotlinx.android.synthetic.main.listitem_route_list.view.*

class KidListAdapter(val items: ArrayList<Model.Kid>, val context: Context):
    RecyclerView.Adapter<KidListAdapter.KidViewHolder>() {

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KidViewHolder {
        return KidViewHolder(LayoutInflater.from(context)
            .inflate(R.layout.listitem_route_list, parent, false))
    }

    override fun onBindViewHolder(holder: KidViewHolder, position: Int) {
        holder.schoolText?.text = items[position].schools.getOrNull(position)?.name
    }

    class KidViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val driverImage = itemView.route_circularimageview_driver_image
        val schoolText = itemView.route_textview_school
        val dateText = itemView.route_textview_date
        val driverText = itemView.route_textview_driver_name
    }

}