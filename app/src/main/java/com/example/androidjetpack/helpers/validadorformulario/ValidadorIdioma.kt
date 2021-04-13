package com.example.androidjetpack.helpers.validadorformulario

class ValidadorIdioma(private val idioma: String) : IValidadorFormulario {

    companion object {
        const val VALIDADOR_IDIOMA = "Idioma"
    }

    override fun validarResultado(): ResultadoValidado {
        return when {
            idioma.isEmpty() -> ResultadoValidado(false, "Completar")
            idioma.length <= 2 -> ResultadoValidado(
                false,
                "La longitud del texto debe ser mayor a 2"
            )
            else -> ResultadoValidado(true)
        }
    }

    override fun getNombreValidador(): String = VALIDADOR_IDIOMA
}