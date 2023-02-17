package com.example.desafio3.domain

import com.example.desafio3.PokemonDetail
import com.example.desafio3.data.PokemonRepositoryImpl

class GetPokemonDetailsUseCase(private val pokemonRepository: PokemonRepositoryImpl) {
    suspend fun execute(id : Int): PokemonDetail {
        return pokemonRepository.getDetailsPokemons(id)
    }
}