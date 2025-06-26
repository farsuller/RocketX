Welcome to RocketX App.
This is a Kotlin Multiplatform project targeting **Android**, **iOS**, and **Desktop**.

### Project Structure

- **`/composeApp`** – Shared code for Compose Multiplatform:
  - `commonMain`: Common code for all platforms.
  - Platform-specific folders (`androidMain`, `iosMain`, etc.): Add platform-only code here (e.g., use CoreCrypto in `iosMain`).

- **`/iosApp`** – Contains the iOS application entry point.
  - Required even when sharing UI via Compose.
  - Add any SwiftUI code here as needed.

📚 Learn more: [Kotlin Multiplatform Docs](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)

---

### 🔧 How to Run the App

**On Windows:**
- To run **Android**, click the **Run** button in Android Studio.
- To run **Desktop**, execute in terminal: `./gradlew run`
- ⚠️ You **cannot run iOS** projects on Windows.

**On macOS:**
- To run **Android**, click the **Run** button in Android Studio.
- To run **iOS**, open the `iosApp` folder in **Xcode** and click **Run**.
- To run **Desktop**, execute in terminal: `./gradlew run`
