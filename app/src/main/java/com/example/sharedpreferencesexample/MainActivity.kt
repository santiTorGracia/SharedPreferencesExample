package com.example.sharedpreferencesexample

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        login.setOnClickListener {
            val sharedPreferences = getSharedPreferences("mySharedPreferences", Context.MODE_PRIVATE)
            val storedUsername = sharedPreferences.getString("username", "")
            val storedPassword = sharedPreferences.getString("password", "")

            if (password.text.toString() == storedPassword && username.text.toString() == storedUsername) {
                Toast.makeText(this, "Login successful", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Incorrect username or password", Toast.LENGTH_LONG).show()
            }
        }

        register.setOnClickListener {
            val sharedPreferences = getSharedPreferences("mySharedPreferences", Context.MODE_PRIVATE)
            sharedPreferences.edit().
                putString("username", username.text.toString()).
                putString("password", password.text.toString()).
                apply()
            Toast.makeText(this, "User ${username.text} successfully registered.", Toast.LENGTH_SHORT).show()
        }
    }
}
