package com.example.androidjetpack.helpers

import android.widget.ImageView
import com.example.androidjetpack.R
import com.squareup.picasso.Picasso

object ImageManager {
    fun loadImage(url: String?, imageView: ImageView) {
        url?.let {
            Picasso
                .get()
                .load(url)
                .placeholder(R.drawable.placeholder_pelicula)
                .into(imageView)
        }
    }
}