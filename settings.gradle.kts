pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")

                // --- THESE ARE THE LINES THAT FIX THE ERROR ---
                includeGroupByRegex("com\\.google\\.devtools.*") // Allows KSP
                includeGroupByRegex("com\\.google\\.dagger.*")   // Allows Hilt
            }
        }

        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "ClickRetina"
include(":app")