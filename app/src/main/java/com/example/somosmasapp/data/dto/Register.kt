package com.example.somosmasapp.data.dto

import com.google.gson.annotations.SerializedName

data class Register(
    @SerializedName("name")
    val name: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String
)
