package com.example.myapplication.Data.DatabaseRoom

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.Data.DatabaseRoom.Dao.AccountDao
import com.example.myapplication.Data.DatabaseRoom.Dao.PistaDao
import com.example.myapplication.Data.DatabaseRoom.Entity.Account
import com.example.myapplication.Data.DatabaseRoom.Entity.Pista


@Database(entities = [Pista::class,Account::class], version = 4)
abstract class SarnanoNeveDB : RoomDatabase() {

    abstract fun pistaDao(): PistaDao
    abstract fun accountDao() : AccountDao


    companion object {
        @Volatile
        private var INSTANCE: SarnanoNeveDB? = null

        operator fun invoke(context: Context): SarnanoNeveDB {
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