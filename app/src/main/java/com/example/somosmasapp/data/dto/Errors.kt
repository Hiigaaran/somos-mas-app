package com.example.somosmasapp.data.dto

/**
 * Dataclass to manage message errors by field in the api call.
 * Resources covered:
 * 1. Login
 * 2. Register
 */
data class Errors(
    val error: String?
    //val name: Array<String>?,
    //val email: Array<String>?,
    //val password: Array<String>?
)
