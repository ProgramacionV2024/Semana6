package com.jalfaro.semana6.models

import java.io.Serializable


data class Libro (
    val nombre: String,
    val autor: String,
    val descripcion: String,
    val existencias: Int
): Serializable
