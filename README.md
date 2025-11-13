# Assignment Submission: ClickRetina – Profile Viewer App

This document serves as the **official assignment submission** for the Android development task. The ClickRetina project demonstrates a clean MVVM architecture, proper use of Jetpack Compose, Retrofit, Hilt, and Glide, along with robust UI state handling and null‑safety improvements.

---

## 📌 Student Submission Details

**Project Name:** ClickRetina – Profile Viewer App

**Objective:** Build an Android application that fetches and displays a user profile from a remote API using modern Android development tools.

**Status:** ✔ Fully Completed

---

## 📱 Demo Screenshot

*Add your screenshots here (as part of the assignment guidelines).* Example:

```
![WhatsApp Image 2025-11-13 at 18 14 05_4f38e810](https://github.com/user-attachments/assets/a707a84a-792a-4347-8f1f-dcd70f4ffc71)

```

---

## ✅ Evaluation Against Requirements

### **✔ Tech Stack Usage (All requirements met)**

The project correctly uses every required tool and technology:

| Requirement       | Status        | Implementation                                                |
| ----------------- | ------------- | ------------------------------------------------------------- |
| Kotlin            | ✔ Used        | Entire codebase is in Kotlin                                  |
| Jetpack Compose   | ✔ Used        | All UI built with composables (ProfileScreen, ProfileContent) |
| Retrofit          | ✔ Implemented | Configured in `ApiService` + `AppModule`                      |
| Glide             | ✔ Used        | Loaded avatar via `GlideImage`                                |
| MVVM Architecture | ✔ Followed    | ViewModel + Repository + Model + UI Screen                    |

---

## ⭐ Features Implemented

### **1. Fetch User Data**

* When the app launches, `ProfileViewModel` fetches profile details from the API.

### **2. Display User Information**

The following fields are shown:

* Name
* Username
* Avatar Image
* City & Country
* Followers & Following
* Shots
* Collections
* Website, Instagram, GitHub links (open in Chrome Custom Tabs)

### **3. UI/UX Standards**

* Clean Material3 UI
* Loading State (Progress Indicator)
* Error Handling State
* Safe rendering of nullable backend data

---

## 🏗 Architecture Overview (MVVM)

```
Presentation Layer
│── ProfileScreen.kt (Compose UI)
│── ProfileContent.kt (UI Components)

Logic Layer
│── ProfileViewModel.kt (State management, network call)

Data Layer
│── ApiService.kt (Retrofit)
│── ProfileRepository.kt
│── Models: Profile, Location, Stats, Links
```

### **UI State Handling**

* `ProfileUiState.Loading`
* `ProfileUiState.Error`
* `ProfileUiState.Success`

This ensures smooth UI updates and avoids crashes.

---

## 🔧 Technical Fixes Implemented

### **1. Null-Safety Crash Fix**

The app previously crashed due to `Text()` receiving a null string.

**Fix:**

* Made model fields nullable OR added default values.
* Added null checks in Compose UI (`?:`, `takeIf`, safe calls).
* Ensured Glide never receives a `null` model.

### **2. Glide Warning Fix**

Added Glide compiler:

```kotlin
kapt("com.github.bumptech.glide:compiler:4.15.1")
```

And created:

```kotlin
@GlideModule
class AppGlideModuleImpl : AppGlideModule()
```

### **3. Improved UI Resilience**

* Social links appear only when non-null & non-blank.
* Avatar shows placeholder behavior when URL is missing.

---

## 📂 Project Structure

```
:app
├─ ui/profile/          # Screens + composables
├─ data/model/          # Profile models
├─ data/network/        # Retrofit services
├─ di/                  # Hilt modules
├─ repository/          # Repository layer
└─ MainActivity.kt
```

---

## ▶️ How to Run

1. Clone the repository:

```bash
git clone https://github.com/yourusername/clickretina.git
```

2. Open it in Android Studio.
3. Let Gradle sync.
4. Run the app on a device/emulator.

---

## 📤 How to Add Screenshots (Assignment Requirement)

1. Create a folder: `screenshots/`
2. Add images such as:

```
screenshots/home.png
screenshots/profile.png
```

3. Reference them in README:

```markdown
![Profile](./screenshots/profile.png)
```

---

## 📑 Conclusion – Assignment Completed Successfully

The **ClickRetina** project fulfills all functional, technical, and architectural requirements of the assignment. It demonstrates:

* Clean MVVM structure
* Modern Compose UI
* Correct use of Retrofit, Hilt, Glide
* Robust handling of API data
* Professional README suitable for academic and professional submission

If you want, I can also:

* Add a **submission summary section**,
* Add **GitHub badges**,
* Add **APK download section**,
* Or format it to match your university’s assignment requirements.
