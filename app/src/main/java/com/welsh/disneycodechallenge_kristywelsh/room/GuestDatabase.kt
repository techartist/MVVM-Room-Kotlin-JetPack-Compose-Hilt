package com.welsh.disneycodechallenge_kristywelsh.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Guest::class), version = 1, exportSchema = false)
public abstract class GuestDatabase : RoomDatabase() {

    abstract fun guestDao(): GuestDao

    companion object {
        @Volatile
        private var INSTANCE: GuestDatabase? = null

        fun getDatabase(context: Context): GuestDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    GuestDatabase::class.java,
                    "guest_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}