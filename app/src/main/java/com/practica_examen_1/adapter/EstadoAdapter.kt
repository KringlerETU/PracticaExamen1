package com.practica_examen_1.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.practica_examen_1.databinding.EstadoFilaBinding
import com.practica_examen_1.model.Estado
import com.practica_examen_1.ui.estado.EstadoFragmentDirections

class EstadoAdapter : RecyclerView.Adapter<EstadoAdapter.EstadoViewHolder>() {
    private var listaEstados = emptyList<Estado>()

    inner class EstadoViewHolder(private val itemBinding: EstadoFilaBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun dibuja(estado: Estado) {
            itemBinding.tvNombre.text = estado.nombre
            itemBinding.tvCapital.text = estado.capital
            itemBinding.tvPoblacion.text = estado.poblacion
            itemBinding.tvPIB.text = estado.PIB
            itemBinding.vistaFila.setOnClickListener {
                val accion = EstadoFragmentDirections.actionNavEstadoToUpdateEstadoFragment(estado)
                itemView.findNavController().navigate(accion)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EstadoViewHolder {
        val itemBinding =
            EstadoFilaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EstadoViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: EstadoViewHolder, position: Int) {
        val lugar = listaEstados[position]
        holder.dibuja(lugar)
    }

    override fun getItemCount(): Int {
        return listaEstados.size
    }

    fun setData(estados: List<Estado>) {
        this.listaEstados = estados
        notifyDataSetChanged()
    }
}