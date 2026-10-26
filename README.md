# Networking Example (Country Explorer)

Android sample app that searches countries via the [REST Countries](https://restcountries.com/) API and shows basic details (flag, capital, region, population). It is built with Kotlin, MVVM, coroutines, StateFlow, Jetpack Compose (Material 3), Retrofit + Moshi, and Coil for image loading.

## Branches
- `main`: Complete walkthrough solution. REST client, data models, and view logic are wired up so the search flow works end-to-end.
- `starter-code`: Scaffold for exercises. Core pieces are left with `TODO` markers (API interface, models, Retrofit client, ViewModel search logic, Compose state observation, and Coil image loading) to be implemented.

## Architecture
- `MainActivity` hosts the Compose UI with `setContent`.
- `ui/SearchScreen.kt` is the screen composable (search bar, status, country details).
- `ui/CountryViewModel.kt` exposes a `StateFlow<SearchUiState>` consumed with `collectAsStateWithLifecycle`.
- `api/` contains the Retrofit + Moshi networking layer (unchanged by the UI toolkit).
- Flag images are loaded with Coil's `AsyncImage`.

## Running
Open the project in Android Studio, let Gradle sync, and run the `app` configuration on an emulator or device. No API key is required for REST Countries.
