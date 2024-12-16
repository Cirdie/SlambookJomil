package com.example.slambookjomong

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.slambookjomong.R

class OnboardingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Enable edge-to-edge UI if needed (optional)
        enableEdgeToEdge()

        // Set the content view for the splash screen
        setContentView(R.layout.activity_on_boarding)

        // Apply window insets to ensure proper padding for system bars (optional)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Delay for 5 seconds (5000 milliseconds) before transitioning to StartActivity
        Handler().postDelayed({
            // Start the next activity (StartActivity) after 5 seconds
            val intent = Intent(this, StartActivity::class.java)
            startActivity(intent)
            // Finish the current activity so it's removed from the back stack
            finish()
        }, 5000)  // 5000 milliseconds = 5 seconds
    }
}
