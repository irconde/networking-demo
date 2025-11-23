package gal.uvigo.networking_example.api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

// TODO 03. Build data classes that represent the API response structure

// TODO 03.01. The @JsonClass annotation here indicates Moshi to be generate the adapter for it
//  during the compile time.
@JsonClass(generateAdapter = true)
data class Country(
    // TODO 03.02. The @Json annotation maps the JSON field "name" to the Kotlin property "countryName".
    // This is good practice to decouple API fields from Kotlin naming conventions and essential for obfuscation safety.
    @Json(name = "name")
    val countryName: Name,
    val capital: List<String>?,
    val region: String,
    val subregion: String?,
    val population: Long,
    val languages: Map<String, String>?,
    val flags: Flags,
    val timezones: List<String>
)

@JsonClass(generateAdapter = true)
data class Name(
    val common: String,
    val official: String
)

@JsonClass(generateAdapter = true)
data class Flags(
    val png: String,
    val svg: String
)
