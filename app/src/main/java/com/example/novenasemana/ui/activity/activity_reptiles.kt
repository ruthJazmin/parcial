package com.example.novenasemana.ui.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.novenasemana.R
import com.example.novenasemana.db.entity.AnimalEntity
import com.example.novenasemana.ui.adapters.AnimalAdapter
import com.example.novenasemana.viewmodel.AnimalViewModel
import kotlinx.android.synthetic.main.activity_main.*

class activity_reptiles : AppCompatActivity() {
    private lateinit var animalViewModel: AnimalViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recycler = recyclerAutos as RecyclerView
        val adapter = AnimalAdapter(this)
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(this)

        animalViewModel = ViewModelProvider(this).get(AnimalViewModel::class.java)
        animalViewModel.reptiles.observe(this, Observer { animals ->
            animals?.let { adapter.setAnimals(animals) }
        })

        idAves.setOnClickListener {
            val intent = Intent(this,activity_aves::class.java)
            startActivityForResult(intent,100)
        }

        idMamiferos.setOnClickListener {
            val intent = Intent(this,activity_mamiferos::class.java)
            startActivityForResult(intent,100)
        }

        idReptiles.setOnClickListener {
            val intent = Intent(this,activity_reptiles::class.java)
            startActivityForResult(intent,100)
        }

        btAdd.setOnClickListener {
            val intent = Intent(this, NewAnimalActivity::class.java)
            startActivityForResult(intent,100)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        lateinit var nombre:String
        lateinit var tipo:String
        lateinit var descripcion:String

        if(requestCode==100 && resultCode == Activity.RESULT_OK){
            data?.getStringExtra("nombre")?.let { nombre = it}
            data?.getStringExtra("tipo")?.let { tipo = it}
            data?.getStringExtra("descripcion")?.let { descripcion = it}

            animalViewModel.insertAnimal(AnimalEntity(nombre = nombre,tipo = tipo, descripcion = descripcion))
        }
    }
}