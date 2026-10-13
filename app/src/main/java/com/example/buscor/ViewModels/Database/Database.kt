package com.example.buscor.ViewModels.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.buscor.Model.DAO.DAO
import com.example.buscor.Model.User.User


@Database(entities = [User::class],
    version = 1, exportSchema = false)
//@TypeConverters(Converters::class)
abstract class MainDatabase : RoomDatabase() {

    abstract fun Dao(): DAO

    companion object {
        @Volatile
        private var INSTANCE: MainDatabase? = null

        fun getDatabase(context: Context): MainDatabase {
            return INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                MainDatabase::class.java,
                "Database").build()
               INSTANCE = instance
                instance
            }
        }
    }
}

//databaseBuilder(
//context.applicationContext,
//Database::class.java,
//"database").build()