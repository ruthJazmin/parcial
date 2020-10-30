package com.example.novenasemana.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.novenasemana.db.entity.AnimalEntity

@Dao
interface AnimalDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAnimal(auto: AnimalEntity)

    @Query("SELECT * FROM animales")
    fun getAnimals():LiveData<List<AnimalEntity>>

    @Query("SELECT * FROM animales WHERE TRIM(tipo) = 'aves'")
    fun getAves():LiveData<List<AnimalEntity>>

    @Query("SELECT * FROM animales WHERE TRIM(tipo) = 'reptiles'")
    fun getReptiles():LiveData<List<AnimalEntity>>

    @Query("SELECT * FROM animales WHERE TRIM(tipo) = 'mamiferos'")
    fun getMamiferos():LiveData<List<AnimalEntity>>

    @Query("DELETE FROM animales")
    fun deleteAutos()
}

