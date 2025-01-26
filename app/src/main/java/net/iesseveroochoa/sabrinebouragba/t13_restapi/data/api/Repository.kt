package net.iesseveroochoa.sabrinebouragba.t13_restapi.data.api

import android.content.Context
import androidx.room.Room
import kotlinx.coroutines.flow.Flow
import net.iesseveroochoa.sabrinebouragba.t13_restapi.data.db.database.PersonajeDataBase
import net.iesseveroochoa.sabrinebouragba.t13_restapi.data.entity.PersonajeFavorito

object Repository {
    // Servicio
    fun getPersonajesApiPagingSource() = ApiRickMortyPagingSource()

    private lateinit var database: PersonajeDataBase

    fun initDatabase(context: Context) {
        database = Room.databaseBuilder(
            context,
            PersonajeDataBase::class.java,
            "personajes_database"
        ).build()
    }

    fun obtenerFavoritos(): Flow<List<PersonajeFavorito>> {
        return database.personajeDao().getAllPersonajes()
    }

    suspend fun agregarFavorito(personaje: PersonajeFavorito) {
        database.personajeDao().addPersonaje(personaje)
    }

    suspend fun eliminarFavorito(personaje: PersonajeFavorito) {
        database.personajeDao().delPersonaje(personaje)
    }

    fun obtenerIdsFavoritos(): Flow<List<Int>> {
        return database.personajeDao().getIdsFavoritos()
    }
}