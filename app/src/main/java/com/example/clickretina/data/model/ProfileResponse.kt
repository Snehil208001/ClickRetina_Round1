package com.example.clickretina.data.model

import com.google.gson.annotations.SerializedName

data class ProfileResponse(
    @SerializedName("profile")
    val profile: Profile? // <-- MODIFIED (added ?)
)