package com.example.androidjetpack.repositories

import com.example.androidjetpack.data.Pelicula
import io.reactivex.Single

interface PeliculasRepository {
    fun getPeliculas(): Single<List<Pelicula>>
}