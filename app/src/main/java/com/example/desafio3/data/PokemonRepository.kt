package com.example.desafio3.data

import com.example.desafio3.PokemonDetail
import com.example.desafio3.PokemonResponse
import com.example.desafio3.RetrofitClient

interface PokemonRepository {
    suspend fun getPokemons(): PokemonResponse
    suspend fun getDetailsPokemons(id : Int): PokemonDetail
}

class PokemonRepositoryImpl(private val api: RetrofitClient) : PokemonRepository {
    override suspend fun getPokemons() = api.pokemonService.getPokemonList()
    override suspend fun getDetailsPokemons(id : Int) = api.pokemonService.getPokemon(id)
}
