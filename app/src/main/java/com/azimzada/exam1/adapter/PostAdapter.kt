package com.azimzada.exam1.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.azimzada.exam1.R
import com.azimzada.exam1.model.MovieDTO
import com.azimzada.exam1.model.ResponseDTO
import com.squareup.picasso.Picasso

class PostAdapter(list: List<MovieDTO>, val listener: OnItemClickListener) :
    RecyclerView.Adapter<PostAdapter.ViewHolder>() {
    var list: List<MovieDTO>

    init {
        this.list = list
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title = itemView.findViewById<TextView>(R.id.titleTV)
        var overview = itemView.findViewById<TextView>(R.id.overviewTV)
        var release_date = itemView.findViewById<TextView>(R.id.release_dateTV)
        var image = itemView.findViewById<ImageView>(R.id.imageView)
        var context = itemView.findViewById<Button>(R.id.btnDetail)
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
        holder.title.setText(list.get(position).original_title)
        holder.overview.setText(list.get(position).overview)
        holder.release_date.setText(list.get(position).release_date)
        Picasso.get()
            .load("https://image.tmdb.org/t/p/w500/${item.poster_path}" )
            .into(holder.image);
        holder.context.setOnClickListener()
        {
            listener.OnItemClick(list[position])
        }
    }
}

interface OnItemClickListener {
    fun OnItemClick(item: MovieDTO)
}
