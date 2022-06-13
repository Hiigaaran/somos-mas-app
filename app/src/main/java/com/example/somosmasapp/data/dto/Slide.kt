package com.example.somosmasapp.data.dto

import com.google.gson.annotations.SerializedName
import java.util.*

data class Slide(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("order")
    val order: Int,
    @SerializedName("user_id")
    val userId: Int,
    @SerializedName("created_at")
    val createdAt: Date,
    @SerializedName("updated_at")
    val updatedAt: Date,
    @SerializedName("deleted_at")
    val deletedAt: Date
)
