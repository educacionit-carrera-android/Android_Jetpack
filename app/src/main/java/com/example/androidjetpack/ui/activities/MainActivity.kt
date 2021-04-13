package com.example.androidjetpack.ui.activities

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.androidjetpack.R
import com.example.androidjetpack.data.Pelicula
import com.example.androidjetpack.navigation.PeliculasNavigation
import com.example.androidjetpack.ui.fragments.*

class MainActivity : AppCompatActivity(), BaseViewListener, PeliculasNavigation {

    private lateinit var layoutLoaders: FrameLayout
    private lateinit var fragmentContainerView: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupUI()
        if (savedInstanceState == null) {
            navigateToSplashScreen()
        }
    }

    private fun setupUI() {
        layoutLoaders = findViewById(R.id.layout_loaders)
        fragmentContainerView = findViewById(R.id.fragmentContainerView)
    }

    private fun navigateToSplashScreen() {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add(
                R.id.fragmentContainerView,
                SplashScreenFragment(),
                SplashScreenFragment::class.java.simpleName
            )
        }
    }

    override fun navigateToPeliculas() {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(
                R.id.fragmentContainerView,
                PeliculasFragment.newInstance(),
                PeliculasFragment::class.java.simpleName
            )
        }
    }

    override fun navigateToDetallesPelicula(pelicula: Pelicula) {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            addToBackStack(null)
            replace(
                R.id.fragmentContainerView,
                PeliculaDetallesFragment.newInstance(pelicula),
                PeliculaDetallesFragment::class.java.simpleName
            )
        }
    }

    override fun navigateToCrearPelicula() {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            addToBackStack(null)
            replace(
                R.id.fragmentContainerView,
                CrearPeliculaFragment.newInstance(),
                PeliculaDetallesFragment::class.java.simpleName
            )
        }
    }

    override fun showLoading(showLoading: Boolean) {
        layoutLoaders.visibility = if (showLoading) {
            View.VISIBLE
        } else {
            View.GONE
        }
    }

    override fun showBackIcon(show: Boolean) {
        supportActionBar?.setDisplayHomeAsUpEnabled(show)
    }

    override fun updateToolbarTitle(title: String) {
        supportActionBar?.title = title
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        showLoading(false)
        super.onBackPressed()
    }
}