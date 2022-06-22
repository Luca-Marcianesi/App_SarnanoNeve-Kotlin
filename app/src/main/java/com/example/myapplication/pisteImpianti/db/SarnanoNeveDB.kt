package com.example.myapplication.pisteImpianti.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Pista::class,Impianto::class], version=2)
abstract class SarnanoNeveDB : RoomDatabase(){

        abstract fun pistaDao(): PistaDao

        abstract fun impiantoDao() : ImpiantoDao

        companion object {
            @Volatile
            private var INSTANCE: SarnanoNeveDB? = null

            fun getInstance(context: Context): SarnanoNeveDB {
                return INSTANCE ?: synchronized(this) {
                    INSTANCE ?: Room.databaseBuilder(
                        context.applicationContext,
                        SarnanoNeveDB::class.java, "SarnanoNeve"
                    ).allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .createFromAsset("database/SarnanoNeve.db")
                        .build()
                }
            }
        }

    }