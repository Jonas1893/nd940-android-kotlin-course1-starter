package com.udacity.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.google.android.material.circularreveal.coordinatorlayout.CircularRevealCoordinatorLayout
import com.udacity.shoestore.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Timber.plant(Timber.DebugTree())

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        setupNavigation(binding)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        super.onCreateOptionsMenu(menu);

        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.logout_menu, menu)
        return true
    }

    private fun setupNavigation(binding: ActivityMainBinding) {
        val navController = this.findNavController(R.id.myNavHostFragment)
        appBarConfiguration = AppBarConfiguration(navController.graph)

        NavigationUI.setupWithNavController(binding.toolbar, navController)
        //NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)
    }
}
