package com.example.clickretina.data.model

import com.google.gson.annotations.SerializedName

data class Profile(
    @SerializedName("name")
    val name: String?, // <-- MODIFIED (added ?)
    @SerializedName("username")
    val username: String?, // <-- MODIFIED (added ?)
    @SerializedName("avatar_url")
    val avatarUrl: String?, // <-- MODIFIED (added ?)
    @SerializedName("location")
    val location: Location?,
    @SerializedName("stats")
    val stats: Stats?,
    @SerializedName("links")
    val links: Links?
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