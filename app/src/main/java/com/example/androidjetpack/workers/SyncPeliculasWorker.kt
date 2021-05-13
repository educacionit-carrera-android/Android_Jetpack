package com.example.androidjetpack.workers

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.androidjetpack.db.PeliculaDatabase

class SyncPeliculasWorker(
    context: Context,
    workerParams: WorkerParameters
) : Worker(context, workerParams) {

    override fun doWork(): Result {
        return try {
            sincronizarPeliculas(applicationContext)
            Result.success()
        } catch (exception: Exception) {
            Result.failure()
        }
    }

    private fun sincronizarPeliculas(context: Context) {
        val peliculas = PeliculaDatabase
            .getInstance(context)
            .peliculaDao()
            .getPeliculasSync()
        Log.i("SyncPeliculasWorker", "SINCRONIZANDO PELICULAS......")
        Log.i("SyncPeliculasWorker", peliculas.toString())
        Log.i("SyncPeliculasWorker", "PELICULAS SINCRONIZADOS")
    }

}