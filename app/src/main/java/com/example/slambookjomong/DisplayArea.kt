package com.example.slambookjomong

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.slambookjomong.databinding.ActivityDisplayAreaBinding

class DisplayArea : AppCompatActivity() {

    private lateinit var binding: ActivityDisplayAreaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize ViewBinding
        binding = ActivityDisplayAreaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Retrieve the SlamBook object passed through the Intent
        val slambook = intent.getSerializableExtra("SlamBook") as? SlamBook

        // If the SlamBook is found, populate the TextViews with the data
        slambook?.let {
            binding.textFirstName.text = it.firstName
            binding.textLastName.text = it.lastName
            binding.textNickname.text = it.nickname
            binding.textHobby.text = it.hobby
            binding.textFavFood.text = it.favFood
            binding.textFavMovie.text = it.favMovie
            binding.textFavMusic.text = it.favMusic
        }

        // Handle the finish button click
        binding.finishButton.setOnClickListener {
            finish() // Close the activity and return to the previous screen
        }
    }
}
