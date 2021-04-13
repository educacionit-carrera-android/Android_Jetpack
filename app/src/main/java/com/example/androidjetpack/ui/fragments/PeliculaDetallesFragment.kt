package com.example.androidjetpack.ui.fragments

import android.os.Bundle
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.example.androidjetpack.R
import com.example.androidjetpack.data.Pelicula
import com.example.androidjetpack.helpers.ImageManager

class PeliculaDetallesFragment : BaseFragment() {

    private lateinit var imgThumbnail: ImageView
    private lateinit var txtTitulo: TextView
    private lateinit var txtEstrellas: TextView
    private lateinit var txtGenero: TextView
    private lateinit var txtFechaLanzamiento: TextView
    private lateinit var txtLenguaje: TextView
    private lateinit var txtDescripcion: TextView
    private var pelicula: Pelicula? = null

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
    ): View? {
        val view = inflater.inflate(R.layout.fragment_pelicula_detalles, container, false)
        configurarUI(view)
        actualizarUI()
        setHasOptionsMenu(true)

        return view
    }

    private fun configurarUI(view: View) {
        imgThumbnail = view.findViewById(R.id.imageViewThumbnail)
        txtTitulo = view.findViewById(R.id.textViewTitulo)
        txtEstrellas = view.findViewById(R.id.textViewEstrellas)
        txtGenero = view.findViewById(R.id.textViewGenero)
        txtFechaLanzamiento = view.findViewById(R.id.textViewFechaLanzamiento)
        txtLenguaje = view.findViewById(R.id.textViewLenguaje)
        txtDescripcion = view.findViewById(R.id.textViewDescripcion)
    }

    private fun actualizarUI() {
        pelicula?.let {
            cargarThumbnail(it.imagen)
            txtTitulo.text = it.nombre
            txtEstrellas.text = it.getCalificacionFormateada()
            txtGenero.text = it.genero
            txtFechaLanzamiento.text = it.anio.toString()
            txtLenguaje.text = it.idioma
            txtDescripcion.text = it.descripcion
        }
    }

    private fun cargarThumbnail(thumbnailUrl: String) {
        ImageManager.loadImage(thumbnailUrl, imgThumbnail)
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