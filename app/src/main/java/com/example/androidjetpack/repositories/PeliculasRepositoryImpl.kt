package com.example.androidjetpack.repositories

import com.example.androidjetpack.data.Pelicula
import com.example.androidjetpack.providers.PeliculasProvider
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class PeliculasRepositoryImpl(
    private val librosProvider: PeliculasProvider
) : PeliculasRepository {

    override fun getPeliculas(): Single<List<Pelicula>> {
        return librosProvider
            .getPeliculas()
            .delay(1500, TimeUnit.MILLISECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}