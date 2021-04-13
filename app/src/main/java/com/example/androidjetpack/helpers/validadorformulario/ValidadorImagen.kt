package com.example.androidjetpack.helpers.validadorformulario

class ValidadorImagen(private val idioma: String) : IValidadorFormulario {

    companion object {
        const val VALIDADOR_IMAGEN = "Imagen"
    }

    override fun validarResultado(): ResultadoValidado {
        return when {
            idioma.isEmpty() -> ResultadoValidado(false, "Completar")
            idioma.length <= 8 -> ResultadoValidado(
                false,
                "La longitud del texto debe ser mayor a 8"
            )
            else -> ResultadoValidado(true)
        }
    }

    override fun getNombreValidador(): String = VALIDADOR_IMAGEN
}