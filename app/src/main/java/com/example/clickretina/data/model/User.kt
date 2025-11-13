package com.example.clickretina.data.model

import com.google.gson.annotations.SerializedName

// This file replaces the old Profile.kt
// It matches the JSON structure you provided.

data class User(
    @SerializedName("name")
    val name: String?,
    @SerializedName("username")
    val username: String?,
    @SerializedName("avatar")
    val avatar: String?,
    @SerializedName("location")
    val location: Location?,
    @SerializedName("social")
    val social: Social?,
    @SerializedName("statistics")
    val statistics: Statistics?
)

data class Location(
    @SerializedName("city")
    val city: String?,
    @SerializedName("country")
    val country: String?
)

data class Social(
    @SerializedName("website")
    val website: String?,
    @SerializedName("profiles")
    val profiles: List<SocialProfile>?
)

data class SocialProfile(
    @SerializedName("platform")
    val platform: String?,
    @SerializedName("url")
    val url: String?
)

data class Statistics(
    @SerializedName("followers")
    val followers: Int?,
    @SerializedName("following")
    val following: Int?,
    @SerializedName("activity")
    val activity: ActivityStats?
)

data class ActivityStats(
    @SerializedName("shots")
    val shots: Int?,
    @SerializedName("collections")
    val collections: Int?
)