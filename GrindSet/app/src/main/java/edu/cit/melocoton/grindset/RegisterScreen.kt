package edu.cit.melocoton.grindset

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RegisterScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 1. Sets the content view first
        setContentView(R.layout.registerscreen)

        // 2. Initializes views INSIDE onCreate
        val userNameInput = findViewById<EditText>(R.id.userInput)
        val signUpBtn = findViewById<TextView>(R.id.SignUpButton)

        // 3. Sets the listener inside onCreate
        signUpBtn.setOnClickListener {
            val newUsername = userNameInput.text.toString()

            if (newUsername.isNotEmpty()) {
                // Saves the registered name into SharedPreferences
                GrindsetPrefs.loginUser(this, newUsername)

                // Goes back to Login
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            } else {
                userNameInput.error = "Field cannot be empty"
            }
        }
    }
}