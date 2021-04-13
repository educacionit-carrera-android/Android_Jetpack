package com.example.androidjetpack.helpers.validadorformulario

class ValidadorNombre(private val nombre: String) : IValidadorFormulario {

    companion object {
        const val VALIDADOR_NOMBRE = "Nombre"
    }

    override fun validarResultado(): ResultadoValidado {
        return when {
            nombre.isEmpty() -> ResultadoValidado(false, "Completar")
            nombre.length <= 1 -> ResultadoValidado(
                false,
                "La longitud del texto debe ser mayor a 1"
            )
            else -> ResultadoValidado(true)
        }
    }

    override fun getNombreValidador(): String = VALIDADOR_NOMBRE
}