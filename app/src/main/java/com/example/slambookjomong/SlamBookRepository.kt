package com.example.slambookjomong


object SlamBookRepository{
    private val slambooks = mutableListOf<SlamBook>()

    fun addSlambook(slambook: SlamBook) {
        slambooks.add(slambook)
    }

    fun getSlambooks(): List<SlamBook> = slambooks

    fun deleteSlambook(slambook: SlamBook) {
        slambooks.remove(slambook)
    }
}
