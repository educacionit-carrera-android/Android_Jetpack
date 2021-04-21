package com.example.androidjetpack.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.androidjetpack.db.dao.PeliculaDao
import com.example.androidjetpack.db.data.PeliculaEntity

const val DB_VERSION = 1
const val DB_NAME = "pelicula_database"

@Database(entities = [PeliculaEntity::class], version = DB_VERSION, exportSchema = false)
abstract class PeliculaDatabase : RoomDatabase() {

    abstract fun peliculaDao(): PeliculaDao

    companion object {
        @Volatile
        private var instance: PeliculaDatabase? = null

        fun getInstance(context: Context): PeliculaDatabase {
            return instance ?: synchronized(this) {
                instance ?: createDatabase(context).also { instance = it }
            }
        }

        private fun createDatabase(context: Context): PeliculaDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                PeliculaDatabase::class.java,
                DB_NAME
            ).build()
        }
    }
}