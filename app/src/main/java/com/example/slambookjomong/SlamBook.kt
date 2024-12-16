package com.example.slambookjomong

import java.io.Serializable

data class SlamBook(
    val firstName: String,
    val lastName: String,
    val nickname: String,
    val hobby: String,
    val favFood: String,
    val favMovie: String,
    val favMusic: String
) : Serializable
