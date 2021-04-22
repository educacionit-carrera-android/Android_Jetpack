package com.example.androidjetpack.repositories

import androidx.paging.PagingSource
import com.example.androidjetpack.data.Pelicula
import com.example.androidjetpack.db.dao.PeliculaDao
import com.example.androidjetpack.db.data.PeliculaEntity
import com.example.androidjetpack.mappers.PeliculaMapper.toPeliculas
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PeliculasRepositoryImpl(
    private val peliculaDao: PeliculaDao
) : PeliculasRepository {

    override fun getPeliculas(): Single<List<Pelicula>> {
        return peliculaDao
            .getPeliculas()
            .map { it.toPeliculas() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    override fun getPeliculasPaging(): PagingSource<Int, PeliculaEntity> {
        return peliculaDao
            .getPeliculasPaging()
    }
}