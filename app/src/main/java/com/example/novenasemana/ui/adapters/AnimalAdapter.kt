package com.example.novenasemana.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.novenasemana.R
import com.example.novenasemana.db.entity.AnimalEntity
import kotlinx.android.synthetic.main.card_auto.view.*

class AnimalAdapter (context: Context)
    :RecyclerView.Adapter<AnimalAdapter.AnimalsViewHolder>(){

    var animals = emptyList<AnimalEntity>()
    var aves = emptyList<AnimalEntity>()
    var reptiles = emptyList<AnimalEntity>()
    var mamiferos = emptyList<AnimalEntity>()
    var inflater:LayoutInflater = LayoutInflater.from(context)

    override fun getItemCount() = animals.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
        = AnimalsViewHolder(inflater.inflate(R.layout.card_auto,parent,false))

    override fun onBindViewHolder(holder: AnimalsViewHolder, position: Int)
            = holder.bind(animals[position])

    internal fun setAnimals(anim:List<AnimalEntity>){
        this.animals = anim
        notifyDataSetChanged()
    }

    internal fun setAves(anim:List<AnimalEntity>){
        this.aves = anim
        notifyDataSetChanged()
    }

    internal fun setReptiles(anim:List<AnimalEntity>){
        this.reptiles = anim
        notifyDataSetChanged()
    }

    internal fun setMamiferos(anim:List<AnimalEntity>){
        this.mamiferos = anim
        notifyDataSetChanged()
    }

    class AnimalsViewHolder(item:View):RecyclerView.ViewHolder(item){
        fun bind(animal:AnimalEntity) {
            itemView.apply {
                nombre.text = animal.nombre
                tipo.text = animal.tipo
                descripcion.text = animal.descripcion
            }
        }
    }
}