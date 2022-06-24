package com.example.somosmasapp.data.dto

import com.google.gson.annotations.SerializedName
import java.util.*

data class Contact(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("phone")
    val phone: String?,
    @SerializedName("message")
    val message: String,
    @SerializedName("created_at")
    val createdAt: Date?,
    @SerializedName("updated_at")
    val updatedAt: Date?,
    @SerializedName("deleted_at")
    val deletedAt: Date?
)
