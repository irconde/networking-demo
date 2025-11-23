package gal.uvigo.networking_example.api

import com.squareup.moshi.Moshi

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

// TODO 04. Retrofit implementation as a singleton
// Retrofit is an expensive object to create and should be used as a singleton.
object RetrofitClient {
    // TODO 04.01. Base URL for the API
    private const val BASE_URL = "https://restcountries.com/v3.1/"

    // TODO 04.02. Create a new instance of Moshi using the builder
    private val moshi = Moshi.Builder().build()

    // TODO 04.03. Create a new instance of Retrofit using the builder.
    //  We need to attach a converter to the Retrofit instance so it knows how to convert the JSON response to a Kotlin object.
    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    // TODO 04.04. Create a new instance of the CountriesApi interface using the Retrofit instance.
    val countriesApi: CountriesApi = retrofit.create(CountriesApi::class.java)
}
