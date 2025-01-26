package net.iesseveroochoa.sabrinebouragba.t13_restapi

import android.app.Application
import net.iesseveroochoa.sabrinebouragba.t13_restapi.data.api.Repository

class PersonajeApplication: Application() {
    companion object{
        lateinit var application: PersonajeApplication
    }
    override fun onCreate() {
        super.onCreate()
        application = this

        Repository.initDatabase(this)
    }
}