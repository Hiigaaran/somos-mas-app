package com.example.somosmasapp.data.dto

import com.google.gson.annotations.SerializedName
import java.util.*

data class Comment(
    @SerializedName("id")
    val id: Int,
    @SerializedName("new_id")
    val newId: Int,
    @SerializedName("user_id")
    val userId: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("text")
    val text: String,
    @SerializedName("visible")
    val visible: Boolean,
    @SerializedName("created_at")
    val createdAt: Date,
    @SerializedName("updated_at")
    val updatedAt: Date,
    @SerializedName("deleted_at")
    val deletedAt: Date
)
