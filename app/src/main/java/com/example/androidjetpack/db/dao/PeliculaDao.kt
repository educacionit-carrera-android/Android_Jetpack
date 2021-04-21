package com.example.androidjetpack.db.dao

import androidx.room.*
import com.example.androidjetpack.db.data.PeliculaEntity
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface PeliculaDao {

    @Insert
    fun insertPelicula(pelicula: PeliculaEntity): Completable

    @Update
    fun actualizarPelicula(pelicula: PeliculaEntity): Completable

    @Delete
    fun borrarPelicula(pelicula: PeliculaEntity): Completable

    @Query("SELECT * FROM pelicula")
    fun getPeliculas(): Single<List<PeliculaEntity>>
}