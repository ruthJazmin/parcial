package com.example.novenasemana.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.novenasemana.db.dao.AnimalDao
import com.example.novenasemana.db.entity.AnimalEntity

@Database(entities = [AnimalEntity::class],version = 1)
abstract class AppRoomDatabase:RoomDatabase(){
    abstract fun animalDao():AnimalDao

    companion object{
        @Volatile
        private var INSTANCE:AppRoomDatabase?=null

        fun getDatabase(context: Context):AppRoomDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppRoomDatabase::class.java,
                    "app"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}