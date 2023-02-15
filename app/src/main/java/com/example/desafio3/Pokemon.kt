package com.example.desafio3

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.SerialName

data class PokemonResponse(
    @SerialName("count") val count: Int,
    @SerialName("next") val next: String,
    @SerialName("previous") val previous: String,
    @SerialName("results") val results: List<Pokemon>
)

@Parcelize
data class Pokemon(
    @SerialName("name") val name: String,
    @SerialName("url") val url: String
) : Parcelable {

    fun getNamePokemon() = name.capitalize()

    fun getIdPokemon(): String {
        val index = url.indexOf("pokemon/")
        return if (index != -1) {
            var id = url.substring(index + "pokemon/".length).replace("/", "")
            while (id.length < 3) {
                id = "0$id"
            }
            id
        } else {
            ""
        }
    }
}

data class PokemonDetail(
    @SerialName("abilities") val abilities: List<Abilities>,
    @SerialName("base_experience") val baseExperience: Int,
    @SerialName("weight") val weight: Int,
    @SerialName("height") val height: Int,
    @SerialName("id") val id: Int,
    @SerialName("moves") val moves: List<Moves>,
    @SerialName("stats") val stats: List<Stats>
)
{
    fun getId() = "0$id"
}

data class Stats(
    @SerialName("base_stat") val baseStat : Int,
    @SerialName("stat") val stat: Stat)

data class Stat(
    @SerialName("name") val name: String)

data class Abilities(
    @SerialName("ability") val ability: AbilitiesData
)

data class AbilitiesData(
    @SerialName("name") val name: String,
    @SerialName("url") val url: String
)

data class Moves(
    @SerialName("move") val move: Move
)

data class Move(
    @SerialName("name") val name: String,
    @SerialName("url") val url: String
)

