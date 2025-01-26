package net.iesseveroochoa.sabrinebouragba.t13_restapi.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import net.iesseveroochoa.sabrinebouragba.t13_restapi.data.entity.PersonajeFavorito

@Dao
interface PersonajeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addPersonaje(personaje: PersonajeFavorito)

    @Delete
    suspend fun delPersonaje(personaje: PersonajeFavorito)

    @Query("SELECT * FROM personajes_favoritos")
    fun getAllPersonajes(): Flow<List<PersonajeFavorito>>

    @Query("SELECT id FROM personajes_favoritos")
    fun getIdsFavoritos(): Flow<List<Int>>
}