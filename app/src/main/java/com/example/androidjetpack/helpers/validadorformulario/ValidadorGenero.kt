package com.example.androidjetpack.helpers.validadorformulario

class ValidadorGenero(private val genero: String) : IValidadorFormulario {

    companion object {
        const val VALIDADOR_GENERO = "Genero"
    }

    override fun validarResultado(): ResultadoValidado {
        return when {
            genero.isEmpty() -> ResultadoValidado(false, "Completar")
            genero.length <= 2 -> ResultadoValidado(
                false,
                "La longitud del texto debe ser mayor a 2"
            )
            else -> ResultadoValidado(true)
        }
    }

    override fun getNombreValidador(): String = VALIDADOR_GENERO
}