package com.example.slambookjomong

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.slambookjomong.databinding.ActivityFillUpBinding

class FillUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFillUpBinding
    private lateinit var progressDialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize ViewBinding
        binding = ActivityFillUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Create the custom progress dialog
        val progressDialogView = layoutInflater.inflate(R.layout.dialog_progress, null)
        progressDialog = AlertDialog.Builder(this)
            .setView(progressDialogView)
            .setCancelable(false)  // Prevent canceling the dialog by clicking outside
            .create()

        // Set click listener for the submit button
        binding.addbuttonSubmit.setOnClickListener {

            // Validate input fields
            if (validateInputs()) {
                // Show the progress dialog
                progressDialog.show()

                // Collect validated data
                val firstName = binding.editFirstName.text.toString().trim()
                val lastName = binding.editLastName.text.toString().trim()
                val nickname = binding.editNickname.text.toString().trim()
                val hobby = binding.editHobby.text.toString().trim()
                val favFood = binding.editFavFood.text.toString().trim()
                val favMovie = binding.editFavMovie.text.toString().trim()
                val favMusic = binding.editFavMusic.text.toString().trim()

                // Create a new SlamBook object with the input data
                val newSlamBook = SlamBook(firstName, lastName, nickname, hobby, favFood, favMovie, favMusic)

                // Simulate saving the SlamBook (replace with actual save logic)
                Thread {
                    // Simulate save time
                    Thread.sleep(2000) // Simulate network/database delay

                    // Add the new SlamBook to the repository
                    SlamBookRepository.addSlambook(newSlamBook)

                    // Navigate to FinishActivity
                    runOnUiThread {
                        // Dismiss the progress dialog
                        progressDialog.dismiss()

                        // Create intent for FinishActivity
                        val intent = Intent(this, FinishActivity::class.java)
                        startActivity(intent)

                        // Optionally finish FillUpActivity to remove it from the back stack
                        finish()
                    }
                }.start() // Start the background thread
            }
        }
    }

    private fun validateInputs(): Boolean {
        val firstName = binding.editFirstName.text.toString().trim()
        val lastName = binding.editLastName.text.toString().trim()
        val nickname = binding.editNickname.text.toString().trim()
        val hobby = binding.editHobby.text.toString().trim()
        val favFood = binding.editFavFood.text.toString().trim()
        val favMovie = binding.editFavMovie.text.toString().trim()
        val favMusic = binding.editFavMusic.text.toString().trim()

        var isValid = true

        // Validate First Name
        if (firstName.isEmpty()) {
            binding.inputFirstName.error = "First name is required"
            isValid = false
        } else {
            binding.inputFirstName.error = null
        }

        // Validate Last Name
        if (lastName.isEmpty()) {
            binding.inputLastName.error = "Last name is required"
            isValid = false
        } else {
            binding.inputLastName.error = null
        }

        // Validate Nickname
        if (nickname.isEmpty()) {
            binding.inputNickname.error = "Nickname is required"
            isValid = false
        } else {
            binding.inputNickname.error = null
        }

        // Validate Hobby
        if (hobby.isEmpty()) {
            binding.inputHobby.error = "Hobby is required"
            isValid = false
        } else {
            binding.inputHobby.error = null
        }

        // Validate Favorite Food
        if (favFood.isEmpty()) {
            binding.inputFavFood.error = "Favorite food is required"
            isValid = false
        } else {
            binding.inputFavFood.error = null
        }

        // Validate Favorite Movie
        if (favMovie.isEmpty()) {
            binding.inputFavMovie.error = "Favorite movie is required"
            isValid = false
        } else {
            binding.inputFavMovie.error = null
        }

        // Validate Favorite Music
        if (favMusic.isEmpty()) {
            binding.inputFavMusic.error = "Favorite music is required"
            isValid = false
        } else {
            binding.inputFavMusic.error = null
        }

        return isValid
    }
}
