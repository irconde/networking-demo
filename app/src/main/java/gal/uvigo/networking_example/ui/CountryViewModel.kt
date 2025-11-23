package gal.uvigo.networking_example.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import gal.uvigo.networking_example.api.Country
import gal.uvigo.networking_example.api.RetrofitClient
import kotlinx.coroutines.launch

class CountryViewModel : ViewModel() {

    private val _countries = MutableLiveData<List<Country>>()
    val countries: LiveData<List<Country>> = _countries

    private val _selectedCountry = MutableLiveData<Country?>()
    val selectedCountry: LiveData<Country?> = _selectedCountry

    private val _status = MutableLiveData<String>()
    val status: LiveData<String> = _status

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error

    // TODO 05. We need to implement the searchCountry function
    //  which is triggered when the Search button is clicked
    fun searchCountry(name: String) {
        if (name.isBlank()) return

        _status.value = "Loading..."
        _error.value = null

        // TODO 05.01. We make the API calls with coroutines
        viewModelScope.launch {
            try {
                // TODO 05.02. We use the RetrofitClient to make the API call
                val result = RetrofitClient.countriesApi.searchCountry(name)

                // TODO 05.03. We update the UI with the results
                if (result.isNotEmpty()) {
                    _countries.value = result
                    _selectedCountry.value = result.first() // Default to first for simple view
                    _status.value = "Found ${result.size} results"
                } else {
                    _countries.value = emptyList()
                    _selectedCountry.value = null
                    _status.value = "No country found"
                    _error.value = "No country found"
                }
            } catch (e: Exception) {
                _countries.value = emptyList()
                _selectedCountry.value = null
                _status.value = "Error: ${e.message}"
                _error.value = "Error loading country: ${e.localizedMessage}"
                e.printStackTrace()
            }
        }
    }

}
