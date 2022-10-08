package com.example.ejercicio2

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.ViewParent
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ejercicio2.databinding.ViewPlaceItemBinding


interface PlaceClickedListener {

    fun onPlaceClicked(place: Place)

}

class Adapter(private val places: List<Place>, private val placeClickedListener: PlaceClickedListener) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding = ViewPlaceItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val place = places[position]
        holder.bind(place)
        holder.itemView.setOnClickListener { placeClickedListener.onPlaceClicked(place) }

    }

    override fun getItemCount() = places.size

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    class ViewHolder(private val binding: ViewPlaceItemBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(place: Place) {

            binding.boton.text = place.nombre

            Glide
                .with(binding.root.context)
                .load(place.foto)
                .into(binding.foto)

        }

    }

}