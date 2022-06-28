package com.practica_examen_1.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "estado")
data class Estado(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "nombre")
    val nombre: String,
    @ColumnInfo(name = "capital")
    val capital: String?,
    @ColumnInfo(name = "poblacion")
    val poblacion: String?,
    @ColumnInfo(name = "PIB")
    val PIB: String?,
) : Parcelable
