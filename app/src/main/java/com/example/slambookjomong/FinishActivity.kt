package com.example.slambookjomong

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FinishActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_fill_up2)

        // Apply window insets for edge-to-edge support (optional)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Delay for 3 seconds before transitioning to ListOfSlambook
        Handler().postDelayed({
            // Create an Intent to navigate to ListOfSlambook activity
            val intent = Intent(this, ListOfSlambook::class.java)
            startActivity(intent)
            finish()  // Optional: to ensure the current activity is finished and not in the back stack
        }, 2000)  // 2000 milliseconds = 2 seconds
    }
}
