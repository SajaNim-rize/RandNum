package com.rand.randnum

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [RandModel::class], version = 1)
abstract class RandDatabase : RoomDatabase() {

    abstract fun randDao(): RandDao

    companion object {

        private var INSTANCE: RandDatabase? = null

        fun getInstance(context: Context): RandDatabase? {

            if (INSTANCE == null) {
                synchronized(RandDatabase::class) {
                    INSTANCE = Room.databaseBuilder(  
                        context.applicationContext,
                        RandDatabase::class.java,
                        "tb_cal"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE
        }

    }
}