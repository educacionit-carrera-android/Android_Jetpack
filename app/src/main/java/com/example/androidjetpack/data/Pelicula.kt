package com.example.androidjetpack.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Pelicula(
    val nombre: String,
    val descripcion: String,
    val genero: String,
    val anio: Int,
    val idioma: String,
    val calificacion: String,
    val imagen: String
) : Parcelable {
    fun getCalificacionFormateada(): String {
        return "$calificacion/10"
    }
}