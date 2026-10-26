package gal.uvigo.networking_example.api

import com.squareup.moshi.Moshi
import gal.uvigo.networking_example.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

// TODO 04. Retrofit implementation as a singleton
// Retrofit is an expensive object to create and should be used as a singleton.

    // TODO 04.01. Base URL for the v5 API

    // TODO 04.02. Create a new instance of Moshi using the builder

    // TODO 04.03. Create a new instance of Retrofit using the builder.
    //  We need to attach a converter to the Retrofit instance so it knows how to convert the JSON response to a Kotlin object.
    //  v5 requires an API key on every request: add an OkHttp interceptor that sends
    //  "Authorization: Bearer <BuildConfig.RESTCOUNTRIES_API_KEY>".

    // TODO 04.04. Create a new instance of the CountriesApi interface using the Retrofit instance.
