package com.example.androidjetpack.helpers.validadorformulario

class ValidadorDescripcion(private val descripcion: String) : IValidadorFormulario {

    companion object {
        const val VALIDADOR_DESCRIPCION = "Descripcion"
    }

    override fun validarResultado(): ResultadoValidado {
        return when {
            descripcion.isEmpty() -> ResultadoValidado(false, "Completar")
            descripcion.length <= 10 -> ResultadoValidado(
                false,
                "La longitud del texto debe ser mayor a 10"
            )
            else -> ResultadoValidado(true)
        }
    }

    override fun getNombreValidador(): String = VALIDADOR_DESCRIPCION
}