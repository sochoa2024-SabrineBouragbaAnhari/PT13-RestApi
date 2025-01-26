package net.iesseveroochoa.sabrinebouragba.t13_restapi.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.DateFormat
import java.util.Date
import java.util.Locale

@Entity(tableName = "personajes")
data class Personaje(
    @PrimaryKey
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val image: String,
    val created: Date
) {
    val estado
        get() = when (status.lowercase()) {
            "alive" -> if (gender.lowercase() == "female") "Viva" else "Vivo"
            "dead" -> if (gender.lowercase() == "female") "Muerta" else "Muerto"
            "unknown" -> if (gender.lowercase() == "female") "Desconocida" else "Desconocido"
            else -> status
        }

    val especie
        get() = when (species.lowercase()) {
            "human" -> if (gender.lowercase() == "female") "Humana" else "Humano"
            "alien" -> "Alienígena"
            "unknown" -> "Desconocida"
            else -> species
        }

    val genero
        get() = when(gender.lowercase()){
            "male"->"Masculino"
            else -> "Femenino"
        }

    val fecha:String
        get(){
            return DateFormat
                .getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
                .format(created)
        }
}