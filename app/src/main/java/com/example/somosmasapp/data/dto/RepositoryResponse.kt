package com.example.somosmasapp.data.dto

data class RepositoryResponse<T>(
    val success: Boolean,
    val data: T,
    val message: String?,
    val errors: Errors?
)
