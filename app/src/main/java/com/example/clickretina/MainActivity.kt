package com.example.clickretina

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.clickretina.ui.profile.ProfileScreen
import com.example.clickretina.ui.theme.ClickRetinaTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint // Add this annotation
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ClickRetinaTheme {
                ProfileScreen()
            }
        }
    }
}