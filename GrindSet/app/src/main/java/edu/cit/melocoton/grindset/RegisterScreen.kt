package edu.cit.melocoton.grindset

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RegisterScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registerscreen)

        val toSignUp = findViewById<TextView>(R.id.SignUpButton)

        toSignUp.setOnClickListener{
            startActivity(Intent(this,LoginActivity::class.java))
        }
    }
}