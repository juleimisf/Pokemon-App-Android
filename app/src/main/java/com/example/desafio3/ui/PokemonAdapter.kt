package com.example.desafio3.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.desafio3.Pokemon
import com.example.desafio3.R

class PokemonAdapter(private val onClick: (Pokemon) -> Unit) :
    RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

    private var pokemonList = listOf<Pokemon>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_pokemon_view, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = pokemonList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(pokemonList[position], onClick)
    }

    fun updatePokemons(pokemon: List<Pokemon>) {
        this.pokemonList = pokemon
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val titleTextView = itemView.findViewById<TextView>(R.id.tv_title)
        private val posterImageView = itemView.findViewById<ImageView>(R.id.iv_poster)

        fun bind(item: Pokemon, onClick: (Pokemon) -> Unit) {
            titleTextView.text = item.name.capitalize()

            val imagePoke = "https://raw.githubusercontent.com/HybridShivam/Pokemon/master/assets/images/${item.getIdPokemon()}.png"
            Glide.with(itemView.context)
                .load(imagePoke)
                .into(posterImageView)

            itemView.setOnClickListener { onClick(item) }
        }
    }
}
