package org.kotlin.preacher.jok3r.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.NavigationUI
import org.kotlin.preacher.jok3r.R

class MainActivity : AppCompatActivity() {

    private val navController: NavController by lazy {
        findNavController(
            this,
            R.id.nav_host_fragment
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    override fun onSupportNavigateUp(): Boolean = navController.navigateUp()
}
