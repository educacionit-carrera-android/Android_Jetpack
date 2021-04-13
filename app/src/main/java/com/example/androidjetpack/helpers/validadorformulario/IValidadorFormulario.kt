package com.example.androidjetpack.helpers.validadorformulario

interface IValidadorFormulario {
    fun validarResultado(): ResultadoValidado
    fun getNombreValidador(): String
}