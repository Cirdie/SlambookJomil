package com.example.slambookjomong

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_start)

        // Apply window insets (optional, based on your design)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Get a reference to the 'Create Slambook' button
        val createButton: Button = findViewById(R.id.createButton)

        // Set the click listener for the 'Create Slambook' button
        createButton.setOnClickListener {
            // Create an Intent to navigate to ListActivity (your list of slambooks)
            val intent = Intent(this, ListOfSlambook::class.java)

            // Start the ListActivity
            startActivity(intent)
        }
    }
}
