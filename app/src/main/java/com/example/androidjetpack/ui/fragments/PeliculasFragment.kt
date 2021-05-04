package com.example.androidjetpack.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.androidjetpack.R
import com.example.androidjetpack.db.PeliculaDatabase
import com.example.androidjetpack.db.data.PeliculaEntity
import com.example.androidjetpack.mappers.PeliculaMapper.toPelicula
import com.example.androidjetpack.repositories.PeliculasRepositoryImpl
import com.example.androidjetpack.ui.adapters.PeliculasPagingAdapter
import com.example.androidjetpack.ui.adapters.helpers.GridItemDecoration
import com.example.androidjetpack.ui.fragments.PeliculaDetallesFragment.Companion.PELICULA
import com.example.androidjetpack.viewmodels.PeliculasViewModel
import com.example.androidjetpack.viewmodels.factories.PeliculasViewModelFactory
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class PeliculasFragment : BaseFragment() {

    private val viewModel: PeliculasViewModel by viewModels {
        PeliculasViewModelFactory(
            PeliculasRepositoryImpl(
                PeliculaDatabase
                    .getInstance(requireContext())
                    .peliculaDao()
            )
        )
    }

    //private val peliculasAdapter = PeliculasAdapter(this::onPeliculaClicked)
    private val peliculasAdapter = PeliculasPagingAdapter(this::onPeliculaClicked)
    private lateinit var rvPeliculas: RecyclerView
    private lateinit var fabAgregar: FloatingActionButton

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
        bindViewModel()
    }

    override fun onResume() {
        super.onResume()
        //viewModel.obtenerPeliculas()
    }

    private fun configurarUI(view: View) {
        rvPeliculas = view.findViewById(R.id.recyclerViewPeliculas)
        rvPeliculas.addItemDecoration(GridItemDecoration(10, 1))

        fabAgregar = view.findViewById(R.id.floatingActionButtonAgregar)
        fabAgregar.setOnClickListener { findNavController().navigate(R.id.goToCrearPelicula) }
    }

    private fun setupAdapter() {
        rvPeliculas.adapter = peliculasAdapter
    }

    private fun bindViewModel() {
        //viewModel.peliculas.observe(viewLifecycleOwner, ::actualizarPeliculas)
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.peliculasPaging.collectLatest {
                peliculasAdapter.submitData(lifecycle, it)
            }
        }
        viewModel.mensaje.observe(viewLifecycleOwner, ::mostrarMensaje)
        viewModel.showLoading.observe(viewLifecycleOwner, ::showLoading)
    }

    /*private fun actualizarPeliculas(peliculas: List<Pelicula>) {
        peliculasAdapter.actualizarPeliculas(peliculas)
    }*/

    private fun onPeliculaClicked(pelicula: PeliculaEntity) {
        findNavController().navigate(
            R.id.goToDetallePelicula, bundleOf(PELICULA to pelicula.toPelicula())
        )
    }
}