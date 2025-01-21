package net.iesseveroochoa.sabrinebouragba.t13_restapi.data.api

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkService {
    private const val URI_BASE = "https://rickandmortyapi.com/api/"

    private val gson = GsonBuilder()
        .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
        .create()

    val servicioRickMorty = Retrofit.Builder()
            .baseUrl(URI_BASE)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

}