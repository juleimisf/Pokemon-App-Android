package com.example.desafio3.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.desafio3.*
import com.example.desafio3.data.PokemonRepositoryImpl
import kotlinx.android.synthetic.main.fragment_pokemons_detail.*

class PokemonDetailFragment : Fragment() {

    private val retrofitService = RetrofitClient

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservable()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pokemons_detail, container, false)
    }

    private fun initObservable() {

        val repositoryImpl = PokemonRepositoryImpl(retrofitService)

        val viewModel = ViewModelProvider(
            this,
            MyViewModelFactory(repositoryImpl)
        )[PokemonViewModel::class.java]

        viewModel.viewStateDetail.observe(requireActivity(), Observer { viewState ->
            when (viewState) {
                is PokemonViewState.Data -> {
                    content_main_view.visibility = View.VISIBLE
                    simple_progress_bar.visibility = View.GONE

                    handlePokemonsList(viewState.data)
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

        val data = requireArguments().getParcelable<Pokemon>(ITEM_DATA_POKEMON)
        tv_name.text = data!!.getNamePokemon()
        viewModel.loadDetailPokemons(data!!.getIdPokemon().toInt())
    }

    private fun handlePokemonsList(item: PokemonDetail) {

        val abilityNames =
            item.abilities.takeLast(4).joinToString(", ") { it.ability.name.capitalize() }
        val movesNames = item.moves.takeLast(3).joinToString(", ") { it.move.name.capitalize() }

        var nameStat = ""

        item.stats.takeLast(3).map {
            nameStat += "${it.stat.name.capitalize()}: ${it.baseStat}  |  "
        }

        weight_value.text = "${item.weight} KG"
        height_value.text = "${item.height} M"

        stat_label.text = nameStat
        moves_value.text = movesNames
        abilities_value.text = abilityNames

        setImage(item)

    }

    private fun setImage(item: PokemonDetail) {
        Log.i("jule",item.getId())
        val imagePoke = "https://raw.githubusercontent.com/HybridShivam/Pokemon/master/assets/images/${item.getId()}.png"
        Glide.with(requireActivity())
            .load(imagePoke)
            .into(iv_poster)
    }
}