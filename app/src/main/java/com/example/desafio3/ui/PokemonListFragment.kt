package com.example.desafio3.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.desafio3.Pokemon
import com.example.desafio3.PokemonViewState
import com.example.desafio3.R
import com.example.desafio3.RetrofitClient
import com.example.desafio3.data.PokemonRepositoryImpl
import kotlinx.android.synthetic.main.fragment_pokemons_list.*

private const val MAX_COLUM = 3
const val ITEM_DATA_POKEMON = "MAX_COLUM"
class PokemonListFragment : Fragment() {

    private lateinit var pokemonListAdapter: PokemonAdapter
    private val retrofitService = RetrofitClient

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initObservable()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pokemons_list, container, false)
    }

    private fun initObservable() {

        val repositoryImpl = PokemonRepositoryImpl(retrofitService)

        val viewModel = ViewModelProvider(
            this,
            MyViewModelFactory(repositoryImpl)
        )[PokemonViewModel::class.java]

        viewModel.viewState.observe(requireActivity(), Observer { viewState ->
            when (viewState) {
                is PokemonViewState.Data -> {
                    handlePokemonList(viewState.data.results)
                }
                is PokemonViewState.Loading -> {
                    simple_progress_bar.visibility = View.VISIBLE
                }
                is PokemonViewState.Error -> {
                    Log.e("Error", "get pokemon list failed :(")
                }
                else -> {
                    throw IllegalArgumentException("No state view")
                }
            }
        })
        viewModel.loadPokemons()
    }

    private fun initView() {
        pokemonListAdapter = PokemonAdapter(::onPokemonClick)

        rv_list.apply {
            layoutManager = GridLayoutManager(context, MAX_COLUM)
            adapter = pokemonListAdapter
        }
    }

    private fun onPokemonClick(item: Pokemon) {
        findNavController().navigate(R.id.action_pokemonsListFragment_to_pokemonsDetailFragment, bundleOf( ITEM_DATA_POKEMON to item))
    }

    private fun handlePokemonList(data: List<Pokemon>) {
        pokemonListAdapter.updatePokemons(data)
        simple_progress_bar.visibility = View.GONE
        rv_list.adapter = pokemonListAdapter
    }
}
