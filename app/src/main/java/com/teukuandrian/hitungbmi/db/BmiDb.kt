package com.teukuandrian.hitungbmi.db

import android.content.Context

@Database(entities = [BmiEntity::class], version = 1, exportSchema = false)
abstract class BmiDb : RoomDatabase() {
    abstract val dao: BmiDao
    companion object {
        @Volatile
        private var INSTANCE: BmiDb? = null
        fun getInstance(context: Context): BmiDb {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                            context.applicationContext,
                            BmiDb::class.java,
                            "bmi.db"
                    )
                            .fallbackToDestructiveMigration()
                            .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
                }