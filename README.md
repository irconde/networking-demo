# Networking Example (Country Explorer)

Android sample app that searches countries via the [REST Countries](https://restcountries.com/) API and shows basic details (flag, capital, region, population). It is built with Kotlin, MVVM, coroutines, LiveData/Data Binding, Retrofit + Moshi, and Glide for image loading.

## Branches
- `main`: Complete walkthrough solution. REST client, data models, and view logic are wired up so the search flow works end-to-end.
- `starter-code`: Scaffold for exercises. Core pieces are left with `TODO` markers (API interface, models, Retrofit client, ViewModel search logic, UI observers/binding adapter) to be implemented.

## Running
Open the project in Android Studio, let Gradle sync, and run the `app` configuration on an emulator or device. No API key is required for REST Countries.
