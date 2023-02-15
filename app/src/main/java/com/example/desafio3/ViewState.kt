package com.example.desafio3

sealed class PokemonViewState<T> {
    data class Data<T>(val data: T) : PokemonViewState<T>()
    class Loading<T>: PokemonViewState<T>()
    class Error<T>(val exception : T) : PokemonViewState<T>()
}