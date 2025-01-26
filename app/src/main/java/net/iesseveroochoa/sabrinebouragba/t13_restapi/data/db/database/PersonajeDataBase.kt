package net.iesseveroochoa.sabrinebouragba.t13_restapi.data.db.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import net.iesseveroochoa.sabrinebouragba.t13_restapi.data.db.dao.PersonajeDao
import net.iesseveroochoa.sabrinebouragba.t13_restapi.data.entity.PersonajeFavorito

@Database(entities = arrayOf(PersonajeFavorito::class), version = 1, exportSchema = false)
@TypeConverters(TransformaFechaSQLite::class)
abstract class PersonajeDataBase: RoomDatabase() {
    abstract fun personajeDao(): PersonajeDao

    companion object {
        // Singleton previene que se abran múltiples instancias de la base de datos
        @Volatile
        private var INSTANCE: PersonajeDataBase? = null

        fun getDatabase(context: Context): PersonajeDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PersonajeDataBase::class.java,
                    "personaje_database"
                )
                    // si queremos que la base de datos se inicie con datos de ejemplo
                    //.addCallback(InicioDbCallback())
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }

}