package com.example.clickretina.ui.profile


import com.example.clickretina.data.model.Profile

sealed interface ProfileUiState {
    data object Loading : ProfileUiState
    data class Success(val profile: Profile) : ProfileUiState
    data class Error(val message: String) : ProfileUiState
}