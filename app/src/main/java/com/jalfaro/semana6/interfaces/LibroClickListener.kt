package com.jalfaro.semana6.interfaces

import com.jalfaro.semana6.models.Libro

interface LibroClickListener {
    fun onClick(libro: Libro): Unit
}