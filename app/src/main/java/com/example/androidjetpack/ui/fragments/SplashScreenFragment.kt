package com.example.androidjetpack.ui.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidjetpack.R

class SplashScreenFragment : BaseFragment() {

    private val delay = 2000L

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_splash_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigateToPeliculasWithDelay()
    }

    private fun navigateToPeliculasWithDelay() {
        Handler(Looper.getMainLooper())
            .postDelayed({
                navigation?.navigateToPeliculas()
            }, delay)
    }
}