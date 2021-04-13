package com.example.androidjetpack.helpers.validadorformulario

class ValidadorCalificacion(private val calificacion: String) : IValidadorFormulario {

    companion object {
        const val VALIDADOR_CALIFICACION = "Calificacion"
    }

    override fun validarResultado(): ResultadoValidado {
        return when {
            calificacion.isEmpty() -> ResultadoValidado(false, "Completar")
            calificacion.toFloat() < 0 || calificacion.toFloat() > 10 -> ResultadoValidado(
                false,
                "Debe ingresar una calificación entre 0 y 10"
            )
            else -> ResultadoValidado(true)
        }
    }

    override fun getNombreValidador(): String = VALIDADOR_CALIFICACION
}