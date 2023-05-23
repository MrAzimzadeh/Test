package com.azimzada.exam1.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.azimzada.exam1.R
import com.azimzada.exam1.model.GenreDTO
import com.azimzada.exam1.model.MovieDTO
import com.squareup.picasso.Picasso

class GengresAdapter
    (list: List<GenreDTO>) :
    RecyclerView.Adapter<GengresAdapter.ViewHolder>() {
    var list: List<GenreDTO>

    init {
        this.list = list
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title = itemView.findViewById<TextView>(R.id.name)

        var id = itemView.findViewById<TextView>(R.id.Id)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.title.setText(list.get(position).name)
        holder.id.setText(list.get(position).id)

    }
}