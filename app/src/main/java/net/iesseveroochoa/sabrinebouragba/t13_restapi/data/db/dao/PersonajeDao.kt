package net.iesseveroochoa.sabrinebouragba.t13_restapi.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import net.iesseveroochoa.sabrinebouragba.t13_restapi.data.db.entity.Personaje

@Dao
interface PersonajeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addPersonaje(personaje: Personaje)

    @Delete
    suspend fun delPersonaje(personaje: Personaje)

    @Query("SELECT * FROM personajes")
    fun getAllPersonajes(): Flow<List<Personaje>>
}