# Networking Example (Country Explorer)

Android sample app that searches countries via the [REST Countries](https://restcountries.com/) **v5** API and shows basic details (flag, capital, region, population). It is built with Kotlin, MVVM, coroutines, StateFlow, Jetpack Compose (Material 3), Retrofit + Moshi, and Coil for image loading.

## Branches
- `main`: Complete walkthrough solution. REST client, data models, and view logic are wired up so the search flow works end-to-end.
- `starter-code`: Scaffold for exercises. Core pieces are left with `TODO` markers (API interface, models, Retrofit client, ViewModel search logic, Compose state observation, and Coil image loading) to be implemented.

## Architecture
- `MainActivity` hosts the Compose UI with `setContent`.
- `ui/SearchScreen.kt` is the screen composable (search bar, status, country details).
- `ui/CountryViewModel.kt` exposes a `StateFlow<SearchUiState>` consumed with `collectAsStateWithLifecycle`.
- `api/` contains the Retrofit + Moshi networking layer (unchanged by the UI toolkit).
- Flag images are loaded with Coil's `AsyncImage`.

## Configuration (API key)
REST Countries **v5** requires an API key on every request. The plain `v3.1` endpoints were retired and now return a deprecation error object, so this app targets `https://api.restcountries.com/countries/v5/`.

1. Create a free key at <https://restcountries.com/sign-up>.
2. Add it to your **`local.properties`** (already git-ignored) in the project root:
   ```properties
   RESTCOUNTRIES_API_KEY=your_key_here
   ```
   The value is injected into `BuildConfig.RESTCOUNTRIES_API_KEY` by `app/build.gradle`; it is never committed.
3. Sync and run. If the key is missing, the app reports "Missing API key" instead of failing silently.

## Running
Open the project in Android Studio, let Gradle sync, and run the `app` configuration on an emulator or device.
