package com.practica_examen_1.viewModel

import android.app.Application
import androidx.lifecycle.*
import com.practica_examen_1.data.EstadoDataBase
import com.practica_examen_1.model.Estado
import com.practica_examen_1.repository.EstadoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EstadoViewModel(application: Application) : AndroidViewModel(application) {
    val getAllData: LiveData<List<Estado>>

    private val repository: EstadoRepository

    init {
        val estadoDAO = EstadoDataBase.getDatabase(application).estadoDAO()
        repository = EstadoRepository(estadoDAO)
        getAllData = repository.getAllData
    }

    fun addEstado(estado: Estado) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addEstado(estado)
        }
    }

    fun updateEstado(estado: Estado) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateEstado(estado)
        }
    }

    fun deleteEstado(estado: Estado) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteEstado(estado)
        }

    }
}