package com.example.androidjetpack.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.androidjetpack.R
import com.example.androidjetpack.data.Pelicula
import com.example.androidjetpack.helpers.validadorformulario.*
import com.example.androidjetpack.helpers.validadorformulario.ValidadorAnio.Companion.VALIDADOR_ANIO
import com.example.androidjetpack.helpers.validadorformulario.ValidadorCalificacion.Companion.VALIDADOR_CALIFICACION
import com.example.androidjetpack.helpers.validadorformulario.ValidadorDescripcion.Companion.VALIDADOR_DESCRIPCION
import com.example.androidjetpack.helpers.validadorformulario.ValidadorGenero.Companion.VALIDADOR_GENERO
import com.example.androidjetpack.helpers.validadorformulario.ValidadorIdioma.Companion.VALIDADOR_IDIOMA
import com.example.androidjetpack.helpers.validadorformulario.ValidadorImagen.Companion.VALIDADOR_IMAGEN
import com.example.androidjetpack.helpers.validadorformulario.ValidadorNombre.Companion.VALIDADOR_NOMBRE

class CrearPeliculaFragment : BaseFragment() {

    private lateinit var etNombre: EditText
    private lateinit var etDescripcion: EditText
    private lateinit var etGenero: EditText
    private lateinit var etAnio: EditText
    private lateinit var etIdioma: EditText
    private lateinit var etCalificacion: EditText
    private lateinit var etImagen: EditText
    private lateinit var buttonCrear: Button
    private val validadorFormulario = ValidadorFormularios()

    companion object {
        fun newInstance(): CrearPeliculaFragment = CrearPeliculaFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        shouldShowBackIcon = true
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_pelicula_crear, container, false)
        configurarUI(view)

        return view
    }

    private fun configurarUI(view: View) {
        etNombre = view.findViewById(R.id.editTextNombre)
        etDescripcion = view.findViewById(R.id.editTextDescripcion)
        etGenero = view.findViewById(R.id.editTextGenero)
        etAnio = view.findViewById(R.id.editTextAnio)
        etIdioma = view.findViewById(R.id.editTextIdioma)
        etCalificacion = view.findViewById(R.id.editTextCalificacion)
        etImagen = view.findViewById(R.id.editTextImagen)
        buttonCrear = view.findViewById(R.id.buttonCrear)
        buttonCrear.setOnClickListener { onButtonCrearClicked() }
    }

    private fun onButtonCrearClicked() {
        validarCampos()
        if (datosValidos()) {
            val pelicula = crearObjetoPelicula()
            // TODO crear pelicula dentro de la DB
            Toast
                .makeText(requireContext(), "Película agregada correctamente", Toast.LENGTH_LONG)
                .show()
            volver()
        }
    }

    private fun validarCampos() {
        val validadores = listOf(
            ValidadorNombre(etNombre.text.toString()),
            ValidadorDescripcion(etDescripcion.text.toString()),
            ValidadorGenero(etGenero.text.toString()),
            ValidadorAnio(etAnio.text.toString()),
            ValidadorCalificacion(etCalificacion.text.toString()),
            ValidadorIdioma(etIdioma.text.toString()),
            ValidadorImagen(etImagen.text.toString()),
        )

        val resultado = validadorFormulario.validar(validadores)
        resolverResultadoValidacion(etNombre, resultado[VALIDADOR_NOMBRE])
        resolverResultadoValidacion(etDescripcion, resultado[VALIDADOR_DESCRIPCION])
        resolverResultadoValidacion(etGenero, resultado[VALIDADOR_GENERO])
        resolverResultadoValidacion(etAnio, resultado[VALIDADOR_ANIO])
        resolverResultadoValidacion(etCalificacion, resultado[VALIDADOR_CALIFICACION])
        resolverResultadoValidacion(etIdioma, resultado[VALIDADOR_IDIOMA])
        resolverResultadoValidacion(etImagen, resultado[VALIDADOR_IMAGEN])
    }

    private fun datosValidos(): Boolean =
        etNombre.error.isNullOrEmpty() &&
                etDescripcion.error.isNullOrEmpty() &&
                etGenero.error.isNullOrEmpty() &&
                etAnio.error.isNullOrEmpty() &&
                etCalificacion.error.isNullOrEmpty() &&
                etIdioma.error.isNullOrEmpty() &&
                etImagen.error.isNullOrEmpty()

    private fun crearObjetoPelicula() = Pelicula(
        etNombre.text.toString(),
        etDescripcion.text.toString(),
        etGenero.text.toString(),
        etAnio.text.toString().toInt(),
        etIdioma.text.toString(),
        etCalificacion.text.toString(),
        etImagen.text.toString()
    )

    private fun resolverResultadoValidacion(
        editText: EditText,
        resultadoValidado: ResultadoValidado?
    ) {
        resultadoValidado?.let {
            if (!it.esValido) {
                editText.error = it.mensajeError
            }
        }
    }

    private fun volver() {
        requireActivity().supportFragmentManager.popBackStack()
    }
}
