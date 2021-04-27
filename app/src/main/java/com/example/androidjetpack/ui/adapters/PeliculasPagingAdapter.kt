package com.example.androidjetpack.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.androidjetpack.R
import com.example.androidjetpack.db.data.PeliculaEntity
import com.example.androidjetpack.helpers.ImageManager

class PeliculasPagingAdapter(
    val listener: PeliculaClickListener
) : PagingDataAdapter<PeliculaEntity, PeliculasPagingAdapter.MovieViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_pelicula, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        getItem(position)?.let { peliculaEntity ->
            cargarImagen(peliculaEntity.imagen, holder.imageViewThumbnail)
            holder.itemView.setOnClickListener {
                listener.onClick(peliculaEntity)
            }
        }
    }

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageViewThumbnail: ImageView = itemView.findViewById(R.id.imageViewThumbnail)
    }

    private fun cargarImagen(url: String?, imageViewThumbnail: ImageView) {
        ImageManager.loadImage(url, imageViewThumbnail)
    }

    fun interface PeliculaClickListener {
        fun onClick(pelicula: PeliculaEntity)
    }

    object DiffCallback : DiffUtil.ItemCallback<PeliculaEntity>() {
        override fun areItemsTheSame(oldItem: PeliculaEntity, newItem: PeliculaEntity): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: PeliculaEntity, newItem: PeliculaEntity): Boolean =
            oldItem == newItem
    }
}
