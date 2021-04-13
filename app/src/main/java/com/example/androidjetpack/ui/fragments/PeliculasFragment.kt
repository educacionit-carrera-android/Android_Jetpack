package com.example.androidjetpack.ui.fragments

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidjetpack.R
import com.example.androidjetpack.data.Pelicula
import com.example.androidjetpack.providers.PeliculasProvider
import com.example.androidjetpack.ui.adapters.PeliculasAdapter
import com.example.androidjetpack.ui.adapters.helpers.GridItemDecoration
import com.google.android.material.floatingactionbutton.FloatingActionButton
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class PeliculasFragment : BaseFragment() {

    private val peliculasAdapter = PeliculasAdapter(this::onPeliculaClicked)
    private lateinit var rvPeliculas: RecyclerView
    private lateinit var fabAgregar: FloatingActionButton

    companion object {
        fun newInstance(): PeliculasFragment = PeliculasFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_peliculas, container, false)
        configurarUI(view)
        actualizarTituloToolbar(getString(R.string.peliculas))

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
    }

    override fun onResume() {
        super.onResume()
        obtenerPeliculas()
    }

    private fun configurarUI(view: View) {
        rvPeliculas = view.findViewById(R.id.recyclerViewPeliculas)
        rvPeliculas.addItemDecoration(GridItemDecoration(10, 3))

        fabAgregar = view.findViewById(R.id.floatingActionButtonAgregar)
        fabAgregar.setOnClickListener { navigation?.navigateToCrearPelicula() }
    }

    private fun setupAdapter() {
        rvPeliculas.adapter = peliculasAdapter
    }

    @SuppressLint("CheckResult")
    private fun obtenerPeliculas() {
        showLoading(true)
        PeliculasProvider()
            .getPeliculas()
            .delay(1500, TimeUnit.MILLISECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doFinally { showLoading(false) }
            .subscribe(
                {
                    peliculasAdapter.actualizarPeliculas(it)
                }, {
                    Log.e(
                        PeliculasFragment::class.java.simpleName,
                        "Error al obtener las películas",
                        it
                    )
                }
            )
    }

    private fun onPeliculaClicked(pelicula: Pelicula) {
        navigation?.navigateToDetallesPelicula(pelicula)
    }
}