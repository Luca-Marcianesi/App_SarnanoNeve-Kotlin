package com.example.myapplication.Data.DatabaseRoom

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.Data.DatabaseRoom.Dao.PistaDao
import com.example.myapplication.Data.DatabaseRoom.Entity.Pista


@Database(entities = [Pista::class], version=1)
abstract class SarnanoNeveDB : RoomDatabase(){

        abstract fun pistaDao(): PistaDao


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
                        .build()
                }
            }
        }

    }