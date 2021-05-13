package com.example.androidjetpack.ui.activities

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.work.*
import com.example.androidjetpack.R
import com.example.androidjetpack.ui.fragments.BaseViewListener
import com.example.androidjetpack.workers.SYNC_PELICULAS
import com.example.androidjetpack.workers.SyncPeliculasWorker
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity(), BaseViewListener {

    private lateinit var layoutLoaders: FrameLayout
    private lateinit var fragmentContainerView: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupUI()
        launchSyncPeliculasWorker()
    }

    private fun setupUI() {
        layoutLoaders = findViewById(R.id.layout_loaders)
        fragmentContainerView = findViewById(R.id.fragmentContainerView)
    }

    override fun showLoading(showLoading: Boolean) {
        layoutLoaders.visibility = if (showLoading) {
            View.VISIBLE
        } else {
            View.GONE
        }
    }

    private fun launchSyncPeliculasWorker() {
        val constraints = Constraints.Builder()
            .setRequiresCharging(true)
            .setRequiredNetworkType(NetworkType.UNMETERED)
            .build()

        val syncWorkRequest: PeriodicWorkRequest =
            PeriodicWorkRequestBuilder<SyncPeliculasWorker>(15, TimeUnit.MINUTES)
                .setConstraints(constraints)
                .build()

        WorkManager
            .getInstance(this)
            .enqueueUniquePeriodicWork(
                SYNC_PELICULAS,
                ExistingPeriodicWorkPolicy.KEEP,
                syncWorkRequest
            )
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