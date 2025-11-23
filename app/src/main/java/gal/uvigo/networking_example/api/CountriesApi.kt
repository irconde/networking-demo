package gal.uvigo.networking_example.api

import retrofit2.http.GET
import retrofit2.http.Path

// TODO 04: Define API Interface
interface CountriesApi {

    // TODO 04.01. We define each API endpoint as a suspend function for a non-blocking code
    // TODO 04.02. We annotate the function indicating the type of request and the endpoint URL
    @GET("name/{name}")
    suspend fun searchCountry(@Path("name") name: String): List<Country>
}
