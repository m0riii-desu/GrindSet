package edu.cit.melocoton.grindset

import android.os.Bundle
import android.app.Activity
import android.content.Intent
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainScreen : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mainscreen)

        // RETRIEVE FROM PREFS
        val username = GrindsetPrefs.getUsername(this)

        val welcomeText = findViewById<TextView>(R.id.welcomeTextView)
        val profile = findViewById<ImageView>(R.id.profileLogo) // RESTORED
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
        val navView = findViewById<NavigationView>(R.id.nav_view)
        val naviBtn = findViewById<ImageView>(R.id.naviBtn)

        welcomeText.text = "Hello, $username!"

        // Open drawer on menu button click
        naviBtn.setOnClickListener { drawerLayout.openDrawer(GravityCompat.START) }

        // Click logic for the profile icon on the main screen
        profile.setOnClickListener {
            val intent = Intent(this, ProfileScreen::class.java)
            // No need for putExtra anymore, ProfileScreen will use SharedPreferences
            startActivity(intent)
        }

        // Handle navigation drawer item clicks
        navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_profile -> { // Ensure this ID matches your drawer_menu.xml
                    val intent = Intent(this, ProfileScreen::class.java)
                    startActivity(intent)
                }
                R.id.nav_logout -> {
                    GrindsetPrefs.logoutUser(this)
                    val intent = Intent(this, LoginActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                    finish()
                }
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }
    }
}