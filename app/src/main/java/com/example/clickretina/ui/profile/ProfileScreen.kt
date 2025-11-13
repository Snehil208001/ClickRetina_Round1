package com.example.clickretina.ui.profile

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.People // <-- IMPORT THIS
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.clickretina.data.model.User // <-- IMPORT NEW User class
import com.example.clickretina.utils.openCustomTab

@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        when (val state = uiState) {
            is ProfileUiState.Loading -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }
            is ProfileUiState.Error -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Failed to load profile: ${state.message}",
                        color = MaterialTheme.colorScheme.error,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
            is ProfileUiState.Success -> {
                ProfileContent(user = state.user) // <-- Pass user object
            }
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ProfileContent(user: User) { // <-- Accept User object
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Avatar
        GlideImage(
            model = user.avatar, // <-- Use user.avatar
            contentDescription = "${user.name ?: "User"}'s avatar",
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Name
        Text(
            text = user.name ?: "Unnamed User",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )
        // Username
        Text(
            text = user.username ?: "@unknown", // <-- Use user.username
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Gray
        )

        // Location
        user.location?.let {
            val city = it.city
            val country = it.country
            if (!city.isNullOrBlank() && !country.isNullOrBlank()) {
                Text(
                    text = "$city, $country",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Stats
        user.statistics?.let { stats -> // <-- Use user.statistics
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                StatItem(value = (stats.followers ?: 0).toString(), label = "Followers")
                StatItem(value = (stats.following ?: 0).toString(), label = "Following")
                // Access nested activity stats
                StatItem(value = (stats.activity?.shots ?: 0).toString(), label = "Shots")
                StatItem(value = (stats.activity?.collections ?: 0).toString(), label = "Collections")
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
        Divider()
        Spacer(modifier = Modifier.height(24.dp))

        // Links
        user.social?.let { social -> // <-- Use user.social
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Website
                social.website?.let {
                    if (it.isNotBlank()) {
                        SocialLink(
                            icon = Icons.Default.Language,
                            text = "Website",
                            onClick = { openCustomTab(context, it) }
                        )
                    }
                }

                // Loop through all profiles in the list
                social.profiles?.forEach { profile ->
                    if (!profile.platform.isNullOrBlank() && !profile.url.isNullOrBlank()) {
                        val icon = when (profile.platform.lowercase()) {
                            "instagram" -> Icons.Default.CameraAlt
                            "facebook" -> Icons.Default.People
                            "github" -> Icons.Default.Code
                            else -> Icons.Default.Language // Fallback
                        }
                        SocialLink(
                            icon = icon,
                            text = profile.platform,
                            onClick = { openCustomTab(context, profile.url) }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun StatItem(value: String, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = value,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = label,
            style = MaterialTheme.typography.bodySmall,
            color = Color.Gray
        )
    }
}

@Composable
fun SocialLink(icon: ImageVector, text: String, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = text,
            tint = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = text,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}