package com.example.polyglotlearn

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class WelcomeActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.navigation_view)

        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar,
            R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navigationView.setNavigationItemSelectedListener { menuItem ->
            // Manejar la selección de elementos del menú
            when (menuItem.itemId) {
                R.id.nav_profile -> {
                    // Navegar a la Activity de Perfil
                    val intent = Intent(this, Perfil::class.java)
                    startActivity(intent)
                }
                R.id.nav_home -> {
                    // Lógica para la opción Home (si es necesario)
                }
                R.id.nav_logout -> {
                    // Lógica para cerrar sesión (si es necesario)
                }
            }

            menuItem.isChecked = true
            drawerLayout.closeDrawers()
            true
        }
    }
}
