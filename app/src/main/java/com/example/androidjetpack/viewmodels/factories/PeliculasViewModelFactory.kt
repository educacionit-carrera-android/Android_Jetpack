package com.example.androidjetpack.viewmodels.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidjetpack.repositories.PeliculasRepository
import com.example.androidjetpack.viewmodels.PeliculasViewModel

class PeliculasViewModelFactory(
    private val peliculasRepository: PeliculasRepository
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PeliculasViewModel(peliculasRepository) as T
    }
}