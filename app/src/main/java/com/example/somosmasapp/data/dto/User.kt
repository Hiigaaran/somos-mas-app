package com.example.somosmasapp.data.dto

import com.google.gson.annotations.SerializedName
import java.util.*

data class User(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("email_verified_at")
    val emailVerifiedAt: Date,
    @SerializedName("password")
    val password: String,
    @SerializedName("role_id")
    val roleId: Int,
    @SerializedName("remember_token")
    val rememberToken: String,
    @SerializedName("created_at")
    val createdAt: Date,
    @SerializedName("updated_at")
    val updatedAt: Date,
    @SerializedName("deleted_at")
    val deletedAt: Date,
    @SerializedName("group_id")
    val groupId: Int,
    @SerializedName("latitude")
    val latitude: Int,
    @SerializedName("longitude")
    val longitude: Int,
    @SerializedName("address")
    val address: String,
    @SerializedName("profile_image")
    val profileImage: String
)
