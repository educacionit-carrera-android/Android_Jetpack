package com.example.androidjetpack.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.androidjetpack.data.Pelicula
import com.example.androidjetpack.repositories.PeliculasRepository
import io.reactivex.disposables.CompositeDisposable

class PeliculasViewModel(
    private val peliculasRepository: PeliculasRepository
) : BaseViewModel() {

    private val compositeDisposable = CompositeDisposable()
    private val _peliculas = MutableLiveData<List<Pelicula>>()
    val peliculas: LiveData<List<Pelicula>> = _peliculas

    val peliculasPaging = Pager(
        PagingConfig(pageSize = 3)
    ) {
        peliculasRepository.getPeliculasPaging()
    }.flow.cachedIn(viewModelScope)

    fun obtenerPeliculas() {
        compositeDisposable.add(
            peliculasRepository
                .getPeliculas()
                .doOnSubscribe { _showLoading.value = true }
                .doFinally { _showLoading.value = false }
                .subscribe({ peliculas ->
                    _peliculas.value = peliculas
                }, {
                    _mensaje.value = "No se pudieron obtener las películas"
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}