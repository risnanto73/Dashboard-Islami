package com.rtid.idnsolo.dashboardislami.inspiration

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rtid.idnsolo.dashboardislami.R

class InspirationListAdapter
    (private val listInspiration: ArrayList<InspirationModel>) :
        RecyclerView.Adapter<InspirationListAdapter.ListViewHolder>()
{
    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgInspiartion : ImageView =  itemView.findViewById(R.id.img_inspiration)
    }

    override fun onCreateViewHolder
                (parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_row_inspiration, parent, false)

        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listInspiration.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val inspiration = listInspiration[position]

        Glide.with(holder.itemView.context)
            .load(inspiration.inspirationImage)
            .into(holder.imgInspiartion)
    }
}