package com.example.androidjetpack.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidjetpack.R
import com.example.androidjetpack.data.Pelicula
import com.example.androidjetpack.helpers.ImageManager

class PeliculasAdapter(val listener: PeliculaClickListener) :
    RecyclerView.Adapter<PeliculasAdapter.MovieViewHolder>() {

    private var peliculas = ArrayList<Pelicula>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_pelicula, parent, false)
        ).apply {
            itemView.setOnClickListener { listener.onClick(peliculas[adapterPosition]) }
        }
    }

    override fun getItemCount(): Int = peliculas.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val pelicula: Pelicula = peliculas[position]
        cargarImagen(pelicula.imagen, holder.imageViewThumbnail)
    }

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageViewThumbnail: ImageView = itemView.findViewById(R.id.imageViewThumbnail)
    }

    private fun cargarImagen(url: String?, imageViewThumbnail: ImageView) {
        ImageManager.loadImage(url, imageViewThumbnail)
    }

    fun actualizarPeliculas(peliculasNuevas: List<Pelicula>) {
        peliculas.apply {
            clear()
            addAll(peliculasNuevas)
        }
        notifyDataSetChanged()
    }

    fun interface PeliculaClickListener {
        fun onClick(pelicula: Pelicula)
    }
}
