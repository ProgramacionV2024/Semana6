package com.jalfaro.semana6.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jalfaro.semana6.models.Libro

class ListadoViewModel: ViewModel() {
    private val _listado =  MutableLiveData(arrayListOf<Libro>())
    val listado: LiveData<ArrayList<Libro>> = _listado

    fun loadingData() {
        _listado.value = arrayListOf(
            Libro("Don Quijote", "Miguel De Cervantes", "Este libro narra las aventuras de Don Quijote y su fiel compañero Sancho Panza", 3),
            Libro("El Alquimista", "Pablo Cohelo", "Este libro habla las aventuras de un alquimista que se encuentra a si mismo", 10),
            Libro("Crimen Y Castigo", "Fedor Dovstoievski", "Este libro narra las aventuras de muchas personas", 45)
        )
    }
}