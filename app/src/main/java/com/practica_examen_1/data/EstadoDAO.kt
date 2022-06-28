package com.practica_examen_1.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.practica_examen_1.model.Estado

@Dao
interface EstadoDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addEstado(estado : Estado)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    fun updateEstado(estado : Estado)

    @Delete
    fun deleteEstado(estado : Estado)

    @Query("SELECT * FROM estado")
    fun getAllData() : LiveData<List<Estado>>
}