package com.example.clickretina.utils

import android.content.Context
import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent

fun openCustomTab(context: Context, url: String) {
    if (url.isBlank()) return
    try {
        val builder = CustomTabsIntent.Builder()
        val customTabsIntent = builder.build()
        customTabsIntent.launchUrl(context, Uri.parse(url))
    } catch (e: Exception) {
        // Handle error, e.g., show a toast
    }
}