package com.example.somosmasapp.data.dto

import com.google.gson.annotations.SerializedName
import java.util.*

data class Testimonial(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("created_at")
    val createdAt: Date,
    @SerializedName("updated_at")
    val updatedAt: Date,
    @SerializedName("deleted_at")
    val deletedAt: Date
)
