package net.iesseveroochoa.sabrinebouragba.t13_restapi.data.api

import net.iesseveroochoa.sabrinebouragba.t13_restapi.data.model.RespuestaRickMorty
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface RickMOrtyService {
    @GET("character")
    suspend fun listaPersonajes(
        @Query("page")
        page: Int
    ): Response<RespuestaRickMorty>

    @GET("character")
    suspend fun listaPersonajes(): Response<RespuestaRickMorty>

    @GET
    suspend fun listaPersonajes(
        @Url
        siguientes: String
    ): Response<RespuestaRickMorty>

}