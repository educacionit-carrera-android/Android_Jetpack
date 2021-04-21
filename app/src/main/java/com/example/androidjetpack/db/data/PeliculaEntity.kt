package com.example.androidjetpack.db.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pelicula")
class PeliculaEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val nombre: String,
    val descripcion: String,
    val genero: String,
    val anio: Int,
    val idioma: String,
    val calificacion: String,
    val imagen: String
)