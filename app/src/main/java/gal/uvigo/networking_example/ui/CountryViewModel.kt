package gal.uvigo.networking_example.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import gal.uvigo.networking_example.BuildConfig
import gal.uvigo.networking_example.api.Country
import gal.uvigo.networking_example.api.RetrofitClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

// Single source of truth for everything the search screen needs to render.
data class SearchUiState(
    val countries: List<Country> = emptyList(),
    val selectedCountry: Country? = null,
    val status: String = "",
    val error: String? = null
)

class CountryViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(SearchUiState())
    val uiState: StateFlow<SearchUiState> = _uiState.asStateFlow()

    // TODO 05. We need to implement the searchCountry function
    //  which is triggered when the Search button is clicked
    fun searchCountry(name: String) {
        if (name.isBlank()) return

        if (BuildConfig.RESTCOUNTRIES_API_KEY.isBlank()) {
            _uiState.update {
                it.copy(
                    status = "Missing API key",
                    error = "Add RESTCOUNTRIES_API_KEY to local.properties"
                )
            }
            return
        }

        _uiState.update { it.copy(status = "Loading...", error = null) }

        // TODO 05.01. We make the API calls with coroutines
        viewModelScope.launch {
            try {
                // TODO 05.02. We use the RetrofitClient to make the API call
                //  v5 wraps the list of countries in data.objects.
                val result = RetrofitClient.countriesApi.searchCountry(name).data?.objects.orEmpty()

                // TODO 05.03. We update the UI state with the results
                if (result.isNotEmpty()) {
                    _uiState.update {
                        it.copy(
                            countries = result,
                            selectedCountry = result.first(), // Default to first for simple view
                            status = "Found ${result.size} results"
                        )
                    }
                } else {
                    _uiState.update {
                        it.copy(
                            countries = emptyList(),
                            selectedCountry = null,
                            status = "No country found",
                            error = "No country found"
                        )
                    }
                }
            } catch (e: Exception) {
                _uiState.update {
                    it.copy(
                        countries = emptyList(),
                        selectedCountry = null,
                        status = "Error: ${e.message}",
                        error = "Error loading country: ${e.localizedMessage}"
                    )
                }
                e.printStackTrace()
            }
        }
    }
}
