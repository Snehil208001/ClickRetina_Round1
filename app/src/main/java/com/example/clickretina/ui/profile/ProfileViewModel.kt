package com.example.clickretina.ui.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.clickretina.data.network.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val apiService: ApiService
) : ViewModel() {

    private val _uiState = MutableStateFlow<ProfileUiState>(ProfileUiState.Loading)
    val uiState: StateFlow<ProfileUiState> = _uiState

    init {
        fetchProfile()
    }

    private fun fetchProfile() {
        viewModelScope.launch {
            _uiState.value = ProfileUiState.Loading
            try {
                val profile = apiService.getProfile()
                _uiState.value = ProfileUiState.Success(profile)
            } catch (e: Exception) {
                _uiState.value = ProfileUiState.Error(e.message ?: "An unknown error occurred")
            }
        }
    }
}