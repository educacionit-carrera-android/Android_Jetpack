package com.example.androidjetpack.repositories

import androidx.paging.PagingSource
import com.example.androidjetpack.data.Pelicula
import com.example.androidjetpack.db.data.PeliculaEntity
import io.reactivex.Single

interface PeliculasRepository {
    fun getPeliculas(): Single<List<Pelicula>>
    fun getPeliculasPaging(): PagingSource<Int, PeliculaEntity>
}