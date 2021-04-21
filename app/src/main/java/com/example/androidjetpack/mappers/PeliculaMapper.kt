package com.example.androidjetpack.mappers

import com.example.androidjetpack.data.Pelicula
import com.example.androidjetpack.db.data.PeliculaEntity

object PeliculaMapper {

    fun Pelicula.toPeliculaEntity() = PeliculaEntity(
        id = id ?: 0,
        nombre = nombre,
        descripcion = descripcion,
        genero = genero,
        anio = anio,
        idioma = idioma,
        calificacion = calificacion,
        imagen = imagen
    )

    fun PeliculaEntity.toPelicula() = Pelicula(
        nombre = nombre,
        descripcion = descripcion,
        genero = genero,
        anio = anio,
        idioma = idioma,
        calificacion = calificacion,
        imagen = imagen,
        id = id
    )

    fun List<PeliculaEntity>.toPeliculas() = map {
        it.toPelicula()
    }
}