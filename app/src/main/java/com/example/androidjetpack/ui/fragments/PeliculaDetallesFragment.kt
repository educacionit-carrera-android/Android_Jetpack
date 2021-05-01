package com.example.androidjetpack.ui.fragments

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AlertDialog
import com.example.androidjetpack.R
import com.example.androidjetpack.data.Pelicula
import com.example.androidjetpack.databinding.FragmentPeliculaDetallesBinding
import com.example.androidjetpack.helpers.ImageManager

class PeliculaDetallesFragment : BaseFragment() {

    private var pelicula: Pelicula? = null
    private lateinit var binding: FragmentPeliculaDetallesBinding

    companion object {
        private const val PELICULA = "Pelicula"

        fun newInstance(pelicula: Pelicula): PeliculaDetallesFragment {
            return PeliculaDetallesFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(PELICULA, pelicula)
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pelicula = arguments?.getParcelable(PELICULA)
        shouldShowBackIcon = true
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPeliculaDetallesBinding.inflate(inflater, container, false).apply {
            pelicula = this@PeliculaDetallesFragment.pelicula
        }
        actualizarUI()
        setHasOptionsMenu(true)

        return binding.root
    }

    private fun actualizarUI() {
        pelicula?.let {
            cargarThumbnail(it.imagen)
        }
    }

    private fun cargarThumbnail(thumbnailUrl: String) {
        ImageManager.loadImage(thumbnailUrl, binding.imageViewThumbnail)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_pelicula_detalle, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.itemEliminar) {
            mostrarConfirmacionEliminarPeliculaDialog()
        }

        return super.onOptionsItemSelected(item)
    }

    private fun mostrarConfirmacionEliminarPeliculaDialog() {
        AlertDialog.Builder(requireContext())
            .setTitle(R.string.eliminar_pelicula)
            .setPositiveButton(R.string.eliminar) { _, _ ->
                // TODO eliminar película
                volver()    // Volver cuando la película se haya eliminado
            }
            .show()
    }

    private fun volver() {
        requireActivity().supportFragmentManager.popBackStack()
    }
}