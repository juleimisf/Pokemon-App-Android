package com.example.desafio3.ui

import androidx.lifecycle.*
import com.example.desafio3.PokemonDetail
import com.example.desafio3.PokemonResponse
import com.example.desafio3.PokemonViewState
import com.example.desafio3.data.PokemonRepositoryImpl
import com.example.desafio3.domain.GetPokemonDetailsUseCase
import com.example.desafio3.domain.GetPokemonListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class PokemonViewModel(repository: PokemonRepositoryImpl) : ViewModel()  {

    private val getPokemonsUseCase = GetPokemonListUseCase(repository)
    private val getPokemonsDetailsUseCase = GetPokemonDetailsUseCase(repository)

    private val _viewState = MutableLiveData<PokemonViewState<PokemonResponse>>()
    val viewState: LiveData<PokemonViewState<PokemonResponse>> = _viewState

    private val _viewStateDetail = MutableLiveData<PokemonViewState<PokemonDetail>>()
    val viewStateDetail: LiveData<PokemonViewState<PokemonDetail>> = _viewStateDetail

    fun loadPokemons() {
        GlobalScope.launch(Dispatchers.Main) {
            val result = getPokemonsUseCase.execute()
            _viewState.value = PokemonViewState.Data(result)
        }
    }


    fun loadDetailPokemons(id : Int) {
        GlobalScope.launch(Dispatchers.Main) {
            val result = getPokemonsDetailsUseCase.execute(id)
            _viewStateDetail.value = PokemonViewState.Data(result)
        }
    }
}

