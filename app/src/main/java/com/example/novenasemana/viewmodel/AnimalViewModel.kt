package com.example.novenasemana.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.novenasemana.db.AppRoomDatabase
import com.example.novenasemana.db.entity.AnimalEntity
import com.example.novenasemana.repository.AnimalRepository
import kotlinx.coroutines.launch

class AnimalViewModel(application: Application):AndroidViewModel(application){

    val animals:LiveData<List<AnimalEntity>>
    val aves:LiveData<List<AnimalEntity>>
    val reptiles:LiveData<List<AnimalEntity>>
    val mamiferos:LiveData<List<AnimalEntity>>
    private val animalRepo:AnimalRepository

    init {
        val animalDao = AppRoomDatabase.getDatabase(application).animalDao()
        animalRepo = AnimalRepository(animalDao)
        animals = animalRepo.animals
        aves = animalRepo.aves
        reptiles = animalRepo.reptiles
        mamiferos = animalRepo.mamiferos
    }

    fun insertAnimal(auto:AnimalEntity) = viewModelScope.launch {
        animalRepo.insertAnimal(auto)
    }

}