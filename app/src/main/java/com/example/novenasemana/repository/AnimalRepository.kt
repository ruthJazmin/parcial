package com.example.novenasemana.repository

import androidx.lifecycle.LiveData
import androidx.room.Query
import com.example.novenasemana.db.dao.AnimalDao
import com.example.novenasemana.db.entity.AnimalEntity

class AnimalRepository (private val AnimalDao:AnimalDao){

    val animals:LiveData<List<AnimalEntity>> = AnimalDao.getAnimals()
    val aves:LiveData<List<AnimalEntity>> = AnimalDao.getAves()
    val reptiles:LiveData<List<AnimalEntity>> = AnimalDao.getReptiles()
    val mamiferos:LiveData<List<AnimalEntity>> = AnimalDao.getMamiferos()



    suspend fun insertAnimal(auto:AnimalEntity){
        AnimalDao.insertAnimal(auto)
    }
}