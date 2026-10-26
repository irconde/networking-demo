package gal.uvigo.networking_example.api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

// TODO 03. Build data classes that represent the API response structure

// v5 wraps every result in a "data" object (check the response shape at
// https://api.restcountries.com/countries/v5/name?q=spain). "data" is null on error responses.
@JsonClass(generateAdapter = true)
data class CountryResponse(
    val data: CountryData? = null
)

@JsonClass(generateAdapter = true)
data class CountryData(
    val objects: List<Country> = emptyList()
)

// TODO 03.01. The @JsonClass annotation here indicates Moshi to be generate the adapter for it
//  during the compile time.
@JsonClass(generateAdapter = true)
data class Country(
    val names: Names,
    val capitals: List<Capital>? = null,
    val region: String,
    val subregion: String? = null,
    val population: Long,
    val languages: List<Language>? = null,
    val flag: Flag,
    val timezones: List<String>
)

@JsonClass(generateAdapter = true)
data class Names(
    val common: String,
    val official: String
)

@JsonClass(generateAdapter = true)
data class Capital(
    val name: String
)

@JsonClass(generateAdapter = true)
data class Language(
    val name: String,
    // TODO 03.02. The @Json annotation maps the JSON field to the Kotlin property. This is good
    //  practice to decouple API fields from Kotlin naming conventions and essential for obfuscation safety.
    @Json(name = "native_name")
    val nativeName: String? = null
)

@JsonClass(generateAdapter = true)
data class Flag(
    @Json(name = "url_png")
    val urlPng: String,
    @Json(name = "url_svg")
    val urlSvg: String
)
