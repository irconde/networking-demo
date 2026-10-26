package gal.uvigo.networking_example.api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

// TODO 03. Build data classes that represent the API response structure. Play special attention to
//  the structure of the json returned by the v5 endpoints. The results are wrapped in a "data"
//  object with an "objects" array, e.g. https://api.restcountries.com/countries/v5/name?q=spain

// TODO 03.01. The @JsonClass annotation here indicates Moshi to be generate the adapter for it
//  during the compile time.

    // TODO 03.02. The @Json annotation maps the JSON field to the Kotlin property. This is good
    //  practice to decouple API fields from Kotlin naming conventions and essential for obfuscation safety.
