package edu.cit.melocoton.grindset

import android.content.Intent
import android.os.Bundle
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity

class SplashScreen : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.splashscreen) //holds the UI

        val layout = findViewById<RelativeLayout>(R.id.splashScreen)  // ID of the whole UI

        layout.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}