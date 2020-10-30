package com.example.novenasemana.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "animales")
data class AnimalEntity(
    @PrimaryKey(autoGenerate = true) val idAnimal:Int = 0,
    @ColumnInfo(name = "nombre") val nombre:String,
    @ColumnInfo(name = "tipo") val tipo:String,
    @ColumnInfo(name = "descripcion") val descripcion:String
)