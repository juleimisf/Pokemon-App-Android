package com.example.desafio3.domain

import com.example.desafio3.PokemonResponse
import com.example.desafio3.data.PokemonRepositoryImpl

class GetPokemonListUseCase(private val pokemonRepository: PokemonRepositoryImpl) {
    suspend fun execute(): PokemonResponse {
        return pokemonRepository.getPokemons()
    }
}