package edu.cit.melocoton.grindset

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class ProfileScreen : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profilescreen)

        val nameDisplay = findViewById<TextView>(R.id.displayName)

        // RETRIEVE FROM PREFS
        nameDisplay.text = GrindsetPrefs.getUsername(this)

        findViewById<ImageView>(R.id.backButton).setOnClickListener {
            finish()
        }
    }
}