package net.iesseveroochoa.sabrinebouragba.t13_restapi.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "personajes_favoritos")
data class PersonajeFavorito(
    @PrimaryKey val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val gender: String,
    val image: String
)