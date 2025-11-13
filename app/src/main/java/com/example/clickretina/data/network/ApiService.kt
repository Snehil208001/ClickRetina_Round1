package com.example.clickretina.data.network


import com.example.clickretina.data.model.Profile
import retrofit2.http.GET

interface ApiService {
    @GET("profile/refs/heads/main/data.json")
    suspend fun getProfile(): Profile

    companion object {
        const val BASE_URL = "https://raw.githubusercontent.com/android-assesment/"
    }
}