package com.practica_examen_1.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.practica_examen_1.model.Estado

@Database(entities = [Estado::class], version = 1, exportSchema = false)
abstract class EstadoDataBase : RoomDatabase() {
    abstract fun estadoDAO(): EstadoDAO

    companion object {

        @Volatile
        private var INSTANCE: EstadoDataBase? = null
        fun getDatabase(context: android.content.Context): EstadoDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    EstadoDataBase::class.java,
                    "estado_data_base"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}