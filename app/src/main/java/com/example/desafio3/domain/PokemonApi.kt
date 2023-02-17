package com.example.desafio3

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApi {
    @GET("pokemon?offset=20&limit=35")
    suspend fun getPokemonList(): PokemonResponse

    @GET("pokemon/{id}/")
    suspend fun getPokemon(@Path("id") id : Int): PokemonDetail

}

object RetrofitClient {
    private const val BASE_URL = "https://pokeapi.co/api/v2/"
    private fun getClient(): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    val retrofit = getClient()

    val pokemonService: PokemonApi = retrofit.create(PokemonApi::class.java)

}




