package com.example.phonebook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val userId = intent.getIntExtra("Id", -1)
        val username = intent.getStringExtra("Name")
        val phone = intent.getStringExtra("Number")
        val email = intent.getStringExtra("Email")

        val tvUserName = findViewById<TextView>(R.id.tvUserName).apply {
            text = username
        }
        val tvUserPhone = findViewById<TextView>(R.id.tvUserPhone).apply {
            text = phone
        }
        val tvUserEmail = findViewById<TextView>(R.id.tvUserEmail).apply {
            text = email
        }
        val backIcon: ImageView = findViewById(R.id.backIcon)
        backIcon.setOnClickListener {
            onBackPressed()
        }
    }
}