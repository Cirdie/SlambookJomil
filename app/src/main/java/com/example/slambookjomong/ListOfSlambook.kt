package com.example.slambookjomong

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.slambookjomong.databinding.ActivityListOfSlambookBinding

class ListOfSlambook : ComponentActivity() {

    private lateinit var binding: ActivityListOfSlambookBinding
    private lateinit var slambooks: MutableList<SlamBook>  // Use MutableList for modification
    private lateinit var adapter: SlambookAdapter  // Declare the adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize ViewBinding
        binding = ActivityListOfSlambookBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize the SlambookRepository and get the list of slambooks
        slambooks = SlamBookRepository.getSlambooks().toMutableList() // Get a mutable list of slambooks

        // Set up RecyclerView
        binding.recyclerViewSlambooks.layoutManager = LinearLayoutManager(this)

        // Set up the adapter with the slambooks data and delete function
        adapter = SlambookAdapter(slambooks,
            onItemClick = { slambook ->
                // Handle item click and pass the clicked SlamBook to the DisplayArea activity
                val intent = Intent(this, DisplayArea::class.java)
                intent.putExtra("SlamBook", slambook) // Pass the SlamBook object as a Serializable extra
                startActivity(intent)
            },
            onDeleteClick = { slambook ->
                deleteSlambook(slambook)  // Handle delete button click
            }
        )

        // Set the adapter to the RecyclerView
        binding.recyclerViewSlambooks.adapter = adapter

        // Find the 'Create Slambook' button and set up the click listener
        val createSlambookButton: Button = findViewById(R.id.createSlambookButton)
        createSlambookButton.setOnClickListener {
            // Create an Intent to navigate to FillUpActivity
            val intent = Intent(this, FillUpActivity::class.java)
            startActivity(intent)
        }

        // Check if the list is empty initially and update empty state
        updateEmptyState()
    }

    // Function to delete a slambook from repository and adapter
    private fun deleteSlambook(slambook: SlamBook) {
        // Remove from repository
        SlamBookRepository.deleteSlambook(slambook)

        // Remove from adapter and update UI
        adapter.removeSlambook(slambook)
        updateEmptyState()  // After deletion, check if the list is empty
    }

    // Function to update the empty state (e.g., show a message when no items are left)
    private fun updateEmptyState() {
        if (slambooks.isEmpty()) {
            // Hide the RecyclerView and show the empty state
            binding.recyclerViewSlambooks.visibility = android.view.View.GONE
            binding.emptyStateContainer.visibility = android.view.View.VISIBLE
        } else {
            // Show the RecyclerView and hide the empty state
            binding.recyclerViewSlambooks.visibility = android.view.View.VISIBLE
            binding.emptyStateContainer.visibility = android.view.View.GONE
        }
    }
}
