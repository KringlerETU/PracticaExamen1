package com.practica_examen_1.ui.estado

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.practica_examen_1.R
import com.practica_examen_1.databinding.FragmentAddEstadoBinding
import com.practica_examen_1.model.Estado
import com.practica_examen_1.viewModel.EstadoViewModel
import androidx.navigation.fragment.findNavController

class addEstadoFragment : Fragment() {
    private lateinit var estadoViewModel : EstadoViewModel

    private var _binding: FragmentAddEstadoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        estadoViewModel = ViewModelProvider(this)[EstadoViewModel::class.java]
        _binding = FragmentAddEstadoBinding.inflate(inflater, container, false)

        binding.btAdd.setOnClickListener { addEstado() }
        return binding.root
    }

    private fun addEstado() {
        val nombre = binding.etNombre.text.toString()
        val capital = binding.etCapital.text.toString()
        val poblacion = binding.etPoblacion.text.toString()
        val PIB = binding.etPIB.text.toString()

        if(nombre.isNotEmpty()){
            val estado = Estado(0,nombre,capital,poblacion,PIB)
            estadoViewModel.addEstado(estado)
            Toast.makeText(requireContext(),getString(R.string.estadoAdded),Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_addEstadoFragment_to_nav_estado)
        }else{
            Toast.makeText(requireContext(),getString(R.string.noData),Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}