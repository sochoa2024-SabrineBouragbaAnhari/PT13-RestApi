package net.iesseveroochoa.sabrinebouragba.t13_restapi.data.repository

import kotlinx.coroutines.flow.Flow
import net.iesseveroochoa.sabrinebouragba.t13_restapi.PersonajeApplication
import net.iesseveroochoa.sabrinebouragba.t13_restapi.data.db.dao.PersonajeDao
import net.iesseveroochoa.sabrinebouragba.t13_restapi.data.db.database.PersonajeDataBase
import net.iesseveroochoa.sabrinebouragba.t13_restapi.data.db.entity.Personaje

object Repository {
    private lateinit var personajeDao: PersonajeDao

    operator fun invoke() {
        personajeDao = PersonajeDataBase
            .getDatabase(PersonajeApplication.application.applicationContext)
            .personajeDao()
    }

    suspend fun addPersonaje(personaje: Personaje) = personajeDao.addPersonaje(personaje)
    suspend fun delPersonaje(personaje: Personaje) = personajeDao.delPersonaje(personaje)
    fun getAllPersonajes(): Flow<List<Personaje>> = personajeDao.getAllPersonajes()
}