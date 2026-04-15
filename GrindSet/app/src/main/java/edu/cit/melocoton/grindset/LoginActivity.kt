package edu.cit.melocoton.grindset

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView

class LoginActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.loginscreen)

        val registerButton = findViewById<TextView>(R.id.SignUpButton)
        val loginButton = findViewById<TextView>(R.id.LoginButton)
        val userName = findViewById<EditText>(R.id.userInput)

        loginButton.setOnClickListener {

            val username = userName.text.toString()

            val intent = Intent(this, MainScreen::class.java)
            intent.putExtra("username_key", username)

            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

            startActivity(intent)
        }

        registerButton.setOnClickListener {
            startActivity(Intent(this, RegisterScreen::class.java))
        }
    }
}