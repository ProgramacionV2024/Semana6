package com.jalfaro.semana6.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.jalfaro.semana6.interfaces.LibroClickListener
import com.jalfaro.semana6.adapters.LibroAdapter
import com.jalfaro.semana6.databinding.FragmentListadoBinding
import com.jalfaro.semana6.models.Libro
import com.jalfaro.semana6.viewmodels.ListadoViewModel


class ListadoFragment : Fragment(), LibroClickListener {
    lateinit var binding: FragmentListadoBinding
    lateinit var viewModel: ListadoViewModel
    lateinit var adapter: LibroAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListadoBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(ListadoViewModel::class.java)
        adapter = LibroAdapter(arrayListOf(), this)
        binding.rcLibros.layoutManager = LinearLayoutManager(context)
        binding.rcLibros.adapter = adapter
        viewModel.listado.observe(viewLifecycleOwner) {
            adapter.showNewData(it.toList())
        }
        viewModel.loadingData()
        return binding.root
    }

    override fun onClick(libro: Libro) {
        val action = ListadoFragmentDirections.actionListadoFragmentToDetalleFragment(libro)
        findNavController().navigate(action)
    }


}