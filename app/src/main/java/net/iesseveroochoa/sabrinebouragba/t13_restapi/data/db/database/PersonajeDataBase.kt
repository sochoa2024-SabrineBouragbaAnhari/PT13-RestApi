package net.iesseveroochoa.sabrinebouragba.t13_restapi.data.db.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import net.iesseveroochoa.sabrinebouragba.t13_restapi.data.db.dao.PersonajeDao
import net.iesseveroochoa.sabrinebouragba.t13_restapi.data.db.entity.Personaje

@Database(entities = arrayOf(Personaje::class), version = 1, exportSchema = false)
@TypeConverters(TransformaFechaSQLite::class)
abstract class PersonajeDataBase: RoomDatabase() {
    abstract fun personajeDao(): PersonajeDao
}