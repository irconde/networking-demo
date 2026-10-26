package gal.uvigo.networking_example.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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

        // TODO 05.01. We make the API calls with coroutines
        viewModelScope.launch {
            try {
                // TODO 05.02. We use the RetrofitClient to make the API call.
                //  v5 wraps the results in data.objects.

                // TODO 05.03. We update the UI state with the results

            } catch (e: Exception) {

            }
        }
    }

}
