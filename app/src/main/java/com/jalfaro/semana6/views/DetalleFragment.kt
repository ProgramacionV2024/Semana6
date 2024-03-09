package com.jalfaro.semana6.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jalfaro.semana6.R
import com.jalfaro.semana6.databinding.FragmentDetalleBinding
import com.jalfaro.semana6.models.Libro


class DetalleFragment : Fragment() {
    lateinit var binding : FragmentDetalleBinding
    var libro: Libro? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetalleBinding.inflate(inflater, container, false);
        libro = arguments?.getSerializable("libro") as Libro

        binding.txtAutor.text = libro?.autor ?: ""
        binding.txtExistencias.text = libro?.existencias.toString() ?: ""
        binding.txtNombre.text = libro?.nombre ?: ""
        binding.txtDescripcion.text = libro?.descripcion ?: ""

        return binding.root
    }

}