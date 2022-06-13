package com.example.somosmasapp.data.dto

import com.google.gson.annotations.SerializedName
import java.util.*

data class Organization(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("logo")
    val logo: String,
    @SerializedName("short_description")
    val shortDescription: String,
    @SerializedName("long_description")
    val longDescription: String,
    @SerializedName("welcome_text")
    val welcomeText: String,
    @SerializedName("address")
    val address: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("cellphone")
    val cellphone: String,
    @SerializedName("created_at")
    val createdAt: Date,
    @SerializedName("updated_at")
    val updatedAt: Date,
    @SerializedName("deleted_at")
    val deletedAt: Date,
    @SerializedName("group_id")
    val groupId: Int,
    @SerializedName("facebook_url")
    val facebookUrl: String,
    @SerializedName("linkedin_url")
    val linkedinUrl: String,
    @SerializedName("instagram_url")
    val instagramUrl: String,
    @SerializedName("twitter_url")
    val twitterUrl: String
)
