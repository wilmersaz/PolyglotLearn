package com.example.polyglotlearn

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.widget.Toolbar
import android.widget.GridLayout

class WelcomeActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var webView: WebView
    private lateinit var gridLayout: GridLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.navigation_view)
        webView = findViewById(R.id.webview)
        gridLayout = findViewById(R.id.grid)

        // Configurar el WebView
        webView.webViewClient = WebViewClient()
        webView.settings.javaScriptEnabled = true

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
                    true
                }
                R.id.nav_translate -> {
                    // Mostrar el WebView y cargar la página
                    gridLayout.visibility = View.GONE
                    webView.visibility = View.VISIBLE
                    webView.loadUrl("https://translate.google.com/?hl=es&sl=en&tl=es&op=translate")
                    true
                }
                R.id.nav_home -> {
                    gridLayout.visibility = View.VISIBLE
                    webView.visibility = View.GONE
                    // Lógica para la opción Welcome
                    val intent = Intent(this, WelcomeActivity::class.java)
                    startActivity(intent)
                    true // Asegúrate de retornar true aquí
                }
                R.id.nav_logout -> {
                    // Navegar a la Activity de login
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }

            menuItem.isChecked = true
            drawerLayout.closeDrawers()
            true
        }
    }
}
