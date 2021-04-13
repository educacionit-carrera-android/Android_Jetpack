package com.example.androidjetpack.helpers.validadorformulario

class ValidadorAnio(private val anio: String) : IValidadorFormulario {

    companion object {
        const val VALIDADOR_ANIO = "Anio"
    }

    override fun validarResultado(): ResultadoValidado {
        return when {
            anio.isEmpty() -> ResultadoValidado(false, "Completar")
            anio.length <= 3 -> ResultadoValidado(false, "Debe ingresar un año válido")
            else -> ResultadoValidado(true)
        }
    }

    override fun getNombreValidador(): String = VALIDADOR_ANIO
}