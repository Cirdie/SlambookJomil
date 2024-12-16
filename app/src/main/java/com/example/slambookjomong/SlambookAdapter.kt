package com.example.slambookjomong

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.slambookjomong.databinding.SlambookItemBinding

class SlambookAdapter(
    private val slambooks: MutableList<SlamBook>,  // Use MutableList to modify the list
    private val onItemClick: (SlamBook) -> Unit,    // Lambda for item click
    private val onDeleteClick: (SlamBook) -> Unit   // Lambda for delete button click
) : RecyclerView.Adapter<SlambookAdapter.SlambookViewHolder>() {

    // ViewHolder to hold the views for each item
    inner class SlambookViewHolder(private val binding: SlambookItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(slambook: SlamBook) {
            // Set the full name
            binding.slambookNameTextView.text = "${slambook.firstName} ${slambook.lastName}"

            // Set up the item click listener
            itemView.setOnClickListener { onItemClick(slambook) }

            // Set up the delete button listener
            binding.removeButton.setOnClickListener { onDeleteClick(slambook) }
        }
    }

    // Create the ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SlambookViewHolder {
        val binding = SlambookItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SlambookViewHolder(binding)
    }

    // Bind data to the ViewHolder
    override fun onBindViewHolder(holder: SlambookViewHolder, position: Int) {
        holder.bind(slambooks[position])
    }

    // Return the size of the list
    override fun getItemCount(): Int = slambooks.size

    // Function to remove a slambook from the list and notify the adapter
    fun removeSlambook(slambook: SlamBook) {
        val position = slambooks.indexOf(slambook)
        if (position != -1) {
            slambooks.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, slambooks.size)
        }
    }
}
