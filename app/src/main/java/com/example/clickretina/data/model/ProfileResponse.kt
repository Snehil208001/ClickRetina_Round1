package com.example.clickretina.data.model

import com.google.gson.annotations.SerializedName

// This file replaces the old ProfileResponse.kt
// It looks for the top-level "user" object from the JSON.

data class ProfileResponse(
    @SerializedName("user")
    val user: User?
)