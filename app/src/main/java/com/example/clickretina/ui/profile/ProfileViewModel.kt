package com.example.clickretina.ui.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.clickretina.data.network.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

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
        // Set Loading state on the Main thread first
        _uiState.value = ProfileUiState.Loading

        // Launch a new coroutine on the IO thread for the network call
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = apiService.getProfile()

                // Switch back to the Main thread to update the UI
                withContext(Dispatchers.Main) {
                    if (response.profile != null) {
                        _uiState.value = ProfileUiState.Success(response.profile)
                    } else {
                        _uiState.value = ProfileUiState.Error("Failed to parse profile data.")
                    }
                }
            } catch (e: Exception) {
                // Switch back to the Main thread to show the error
                withContext(Dispatchers.Main) {
                    _uiState.value = ProfileUiState.Error(e.message ?: "An unknown error occurred")
                }
            }
        }
    }
}