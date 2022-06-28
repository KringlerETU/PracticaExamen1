package com.practica_examen_1.ui.estado

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.practica_examen_1.R
import com.practica_examen_1.databinding.FragmentUpdateEstadoBinding
import com.practica_examen_1.model.Estado
import com.practica_examen_1.viewModel.EstadoViewModel
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import java.nio.file.Files.delete

class updateEstadoFragment : Fragment() {
    private val args by navArgs<updateEstadoFragmentArgs>()
    private lateinit var estadoViewModel: EstadoViewModel

    private var _binding: FragmentUpdateEstadoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        estadoViewModel = ViewModelProvider(this)[EstadoViewModel::class.java]
        _binding = FragmentUpdateEstadoBinding.inflate(inflater, container, false)

        binding.btActualizar.setOnClickListener { UpdateEstado() }
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
    }

    //Acá se genera el menú con el icono de borrar
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_delete) {
            deleteEstado()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteEstado() {
        val consulta = AlertDialog.Builder(requireContext())

        consulta.setTitle(R.string.delete)
        consulta.setMessage(getString(R.string.seguroBorrar) + " ${args.estado.nombre}?")

        consulta.setPositiveButton(getString(R.string.si)) { _, _ -> //borramos el lugar... sin cosultar
            estadoViewModel.deleteEstado(args.estado)
            findNavController().navigate(R.id.action_updateEstadoFragment_to_nav_estado)
        }
        consulta.setNegativeButton(R.string.no) { _, _ ->
        }
        consulta.create().show()

    }


    private fun UpdateEstado() {
        val nombre = binding.etNombre.text.toString()
        val capital = binding.etCapital.text.toString()
        val poblacion = binding.etPoblacion.text.toString()
        val PIB = binding.etPIB.text.toString()

        if (nombre.isNotEmpty()) {
            val estado = Estado(args.estado.id, nombre, capital, poblacion, PIB)
            estadoViewModel.updateEstado(estado)
            Toast.makeText(requireContext(), getString(R.string.estadoUpdated), Toast.LENGTH_SHORT)
                .show()
            findNavController().navigate(R.id.action_updateEstadoFragment_to_nav_estado)
        } else {
            Toast.makeText(requireContext(), getString(R.string.noData), Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}