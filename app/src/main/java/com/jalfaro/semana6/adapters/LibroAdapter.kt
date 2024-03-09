package com.jalfaro.semana6.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jalfaro.semana6.interfaces.LibroClickListener
import com.jalfaro.semana6.databinding.LibroItemLayoutBinding
import com.jalfaro.semana6.models.Libro

class LibroAdapter(val listado: ArrayList<Libro>, val clickListener: LibroClickListener): RecyclerView.Adapter<LibroAdapter.LibroViewHolder>() {
    class LibroViewHolder(val binding: LibroItemLayoutBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LibroViewHolder =
        LibroViewHolder(LibroItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun getItemCount(): Int = listado.size

    override fun onBindViewHolder(holder: LibroViewHolder, position: Int) {
        holder.binding.txtAutor.text = listado[position].autor
        holder.binding.txtNombre.text = listado[position].nombre
        holder.binding.root.setOnClickListener {
            clickListener.onClick(listado[position])
        }
    }

    fun showNewData(newData: List<Libro>) {
        listado.clear()
        listado.addAll(newData)
        this.notifyDataSetChanged()
    }
}