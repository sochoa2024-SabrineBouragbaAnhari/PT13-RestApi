package net.iesseveroochoa.sabrinebouragba.t13_restapi.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import net.iesseveroochoa.sabrinebouragba.t13_restapi.data.entity.PersonajeFavorito
import net.iesseveroochoa.sabrinebouragba.t13_restapi.data.model.Personaje

@Dao
interface PersonajeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addPersonaje(personaje: PersonajeFavorito)

    @Delete
    suspend fun delPersonaje(personaje: PersonajeFavorito)

    @Query("SELECT id FROM personajes_favoritos")
    fun getIdsFavoritos(): Flow<List<Int>>

    @Query("SELECT * FROM personajes_favoritos")
    fun getAllPersonajesFavoritos(): Flow<List<PersonajeFavorito>>
}