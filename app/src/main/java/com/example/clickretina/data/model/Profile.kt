package com.example.clickretina.data.model

import com.google.gson.annotations.SerializedName

data class Profile(
    @SerializedName("name")
    val name: String,
    @SerializedName("username")
    val username: String,
    @SerializedName("avatar_url")
    val avatarUrl: String,
    @SerializedName("location")
    val location: Location?, // From our previous fix
    @SerializedName("stats")
    val stats: Stats?, // From our previous fix
    @SerializedName("links")
    val links: Links? // <-- ADDED NULLABLE ? HERE
)

data class Location(
    @SerializedName("city")
    val city: String,
    @SerializedName("country")
    val country: String
)

data class Stats(
    @SerializedName("followers")
    val followers: Int,
    @SerializedName("following")
    val following: Int,
    @SerializedName("shots")
    val shots: Int,
    @SerializedName("collections")
    val collections: Int
)

data class Links(
    @SerializedName("website")
    val website: String?,
    @SerializedName("instagram")
    val instagram: String?,
    @SerializedName("github")
    val github: String?
)