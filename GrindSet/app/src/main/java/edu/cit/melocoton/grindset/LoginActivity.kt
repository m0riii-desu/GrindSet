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
            val inputName = userName.text.toString()

            // Retrieve the "Registered" name from SharedPreferences
            val registeredName = GrindsetPrefs.getUsername(this)

            if (inputName.isEmpty()) {
                userName.error = "Please enter a username"
                return@setOnClickListener
            }

            // Compares input with stored data
            if (inputName == registeredName) {
                // Update session to logged in
                GrindsetPrefs.loginUser(this, inputName)

                val intent = Intent(this, MainScreen::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
            } else {
                userName.error = "Username not found. Please register first!"
            }
        }

        registerButton.setOnClickListener {
            startActivity(Intent(this, RegisterScreen::class.java))
        }
    }
}