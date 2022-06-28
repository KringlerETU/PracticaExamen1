package com.practica_examen_1.repository

import androidx.lifecycle.LiveData
import com.practica_examen_1.data.EstadoDAO
import com.practica_examen_1.model.Estado

class EstadoRepository (private val estadoDAO: EstadoDAO) {

    val getAllData: LiveData<List<Estado>> = estadoDAO.getAllData()

    suspend fun addEstado(estado: Estado) {
        estadoDAO.addEstado(estado)
    }

    suspend fun updateEstado(estado: Estado) {
        estadoDAO.updateEstado(estado)
    }

    suspend fun deleteEstado(estado: Estado) {
        estadoDAO.deleteEstado(estado)
    }
}