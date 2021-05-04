package com.example.androidjetpack.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.navigation.fragment.findNavController
import com.example.androidjetpack.data.Pelicula
import com.example.androidjetpack.databinding.FragmentPeliculaCrearBinding
import com.example.androidjetpack.db.PeliculaDatabase
import com.example.androidjetpack.helpers.validadorformulario.*
import com.example.androidjetpack.helpers.validadorformulario.ValidadorAnio.Companion.VALIDADOR_ANIO
import com.example.androidjetpack.helpers.validadorformulario.ValidadorCalificacion.Companion.VALIDADOR_CALIFICACION
import com.example.androidjetpack.helpers.validadorformulario.ValidadorDescripcion.Companion.VALIDADOR_DESCRIPCION
import com.example.androidjetpack.helpers.validadorformulario.ValidadorGenero.Companion.VALIDADOR_GENERO
import com.example.androidjetpack.helpers.validadorformulario.ValidadorIdioma.Companion.VALIDADOR_IDIOMA
import com.example.androidjetpack.helpers.validadorformulario.ValidadorImagen.Companion.VALIDADOR_IMAGEN
import com.example.androidjetpack.helpers.validadorformulario.ValidadorNombre.Companion.VALIDADOR_NOMBRE
import com.example.androidjetpack.mappers.PeliculaMapper.toPeliculaEntity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class CrearPeliculaFragment : BaseFragment() {

    private val validadorFormulario = ValidadorFormularios()
    private val compositeDisposable = CompositeDisposable()
    private var _binding: FragmentPeliculaCrearBinding? = null
    private val binding get() = _binding!! // Propiedad válida entre onCreateView y onDestroyView.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        shouldShowBackIcon = true
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPeliculaCrearBinding.inflate(inflater, container, false)
        configurarUI()

        return binding.root
    }

    private fun configurarUI() {
        binding.buttonCrear.setOnClickListener { onButtonCrearClicked() }
    }

    private fun onButtonCrearClicked() {
        validarCampos()
        if (datosValidos()) {
            val pelicula = crearObjetoPelicula()
            crearPelicula(pelicula)
        }
    }

    private fun crearPelicula(pelicula: Pelicula) {
        compositeDisposable.add(
            PeliculaDatabase
                .getInstance(requireContext())
                .peliculaDao()
                .insertPelicula(pelicula.toPeliculaEntity())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    mostrarMensaje("Película agregada correctamente")
                    volver()
                }, {
                    mostrarMensaje("Hubo un error al querer agregar la pelicula")
                    Log.e(CrearPeliculaFragment::class.simpleName, it.message, it)
                })
        )
    }

    private fun validarCampos() {
        binding.apply {
            val validadores = listOf(
                ValidadorNombre(editTextNombre.text.toString()),
                ValidadorDescripcion(editTextDescripcion.text.toString()),
                ValidadorGenero(editTextGenero.text.toString()),
                ValidadorAnio(editTextAnio.text.toString()),
                ValidadorCalificacion(editTextCalificacion.text.toString()),
                ValidadorIdioma(editTextIdioma.text.toString()),
                ValidadorImagen(editTextImagen.text.toString()),
            )

            val resultado = validadorFormulario.validar(validadores)
            resolverResultadoValidacion(editTextNombre, resultado[VALIDADOR_NOMBRE])
            resolverResultadoValidacion(editTextDescripcion, resultado[VALIDADOR_DESCRIPCION])
            resolverResultadoValidacion(editTextGenero, resultado[VALIDADOR_GENERO])
            resolverResultadoValidacion(editTextAnio, resultado[VALIDADOR_ANIO])
            resolverResultadoValidacion(editTextCalificacion, resultado[VALIDADOR_CALIFICACION])
            resolverResultadoValidacion(editTextIdioma, resultado[VALIDADOR_IDIOMA])
            resolverResultadoValidacion(editTextImagen, resultado[VALIDADOR_IMAGEN])
        }
    }

    private fun datosValidos(): Boolean =
        with(binding) {
            editTextNombre.error.isNullOrEmpty() &&
                    editTextDescripcion.error.isNullOrEmpty() &&
                    editTextGenero.error.isNullOrEmpty() &&
                    editTextAnio.error.isNullOrEmpty() &&
                    editTextCalificacion.error.isNullOrEmpty() &&
                    editTextIdioma.error.isNullOrEmpty() &&
                    editTextImagen.error.isNullOrEmpty()
        }

    private fun crearObjetoPelicula() = Pelicula(
        binding.editTextNombre.text.toString(),
        binding.editTextDescripcion.text.toString(),
        binding.editTextGenero.text.toString(),
        binding.editTextAnio.text.toString().toInt(),
        binding.editTextIdioma.text.toString(),
        binding.editTextCalificacion.text.toString(),
        binding.editTextImagen.text.toString()
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
        findNavController().popBackStack()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        compositeDisposable.clear()
        _binding = null
    }
}
