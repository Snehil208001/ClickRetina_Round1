package com.example.clickretina.ui.profile

import com.example.clickretina.data.model.User // <-- IMPORT NEW User class

sealed interface ProfileUiState {
    data object Loading : ProfileUiState
    data class Success(val user: User) : ProfileUiState // <-- Use User object
    data class Error(val message: String) : ProfileUiState
}