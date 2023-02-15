package com.example.desafio3

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class PokemonAdapter(private val onClick: (Pokemon) -> Unit) :
    RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

    private var movies = listOf<Pokemon>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_movie_view, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = movies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movies[position], onClick)
    }

    fun updatePokemons(movies: List<Pokemon>) {
        this.movies = movies
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
