package com.example.androidjetpack.helpers.validadorformulario

class ValidadorFormularios {
    fun validar(validadores: List<IValidadorFormulario>): Map<String, ResultadoValidado> {
        val resultadoValidadores = mutableMapOf<String, ResultadoValidado>()

        for (validador in validadores) {
            resultadoValidadores[validador.getNombreValidador()] = validador.validarResultado()
        }

        return resultadoValidadores
    }
}