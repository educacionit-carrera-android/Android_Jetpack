package com.example.androidjetpack.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {
    private var viewListener: BaseViewListener? = null
    protected var shouldShowBackIcon = false

    private fun showBackIcon(show: Boolean) = viewListener?.showBackIcon(show)

    fun showLoading(show: Boolean) = viewListener?.showLoading(show)

    fun actualizarTituloToolbar(title: String) = viewListener?.updateToolbarTitle(title)

    fun mostrarMensaje(mensaje: String) {
        Toast.makeText(requireContext(), mensaje, Toast.LENGTH_LONG).show()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewListener = context as? BaseViewListener
    }

    override fun onDetach() {
        super.onDetach()
        viewListener = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showBackIcon(shouldShowBackIcon)
    }
}

interface BaseViewListener {
    fun showLoading(showLoading: Boolean)
    fun showBackIcon(show: Boolean)
    fun updateToolbarTitle(title: String)
}
