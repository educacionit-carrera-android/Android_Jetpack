package com.example.androidjetpack.navigation

import com.example.androidjetpack.data.Pelicula

interface PeliculasNavigation {
    fun navigateToPeliculas()
    fun navigateToDetallesPelicula(pelicula: Pelicula)
    fun navigateToCrearPelicula()
}