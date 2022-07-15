package com.example.myapplication.Data.DatabaseRoom

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.Data.DatabaseRoom.Dao.PistaDao
import com.example.myapplication.Data.DatabaseRoom.Dao.PreferenzeDao
import com.example.myapplication.Data.DatabaseRoom.Entity.Pista
import com.example.myapplication.Data.DatabaseRoom.Entity.Preferenza


@Database(entities = [Pista::class,Preferenza::class], version=2)
abstract class SarnanoNeveDB : RoomDatabase(){

        abstract fun pistaDao(): PistaDao
        abstract fun preferenzeDao() : PreferenzeDao


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