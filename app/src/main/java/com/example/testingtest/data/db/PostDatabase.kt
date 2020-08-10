package com.example.testingtest.data.db

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.Database

@Database(entities = [PostDBWrapper::class], version = 1)
abstract class PostDatabase : RoomDatabase() {

    abstract fun appPostDao(): PostDao
    companion object {
        @Volatile
        private var INSTANCE: PostDatabase? = null

        fun getDatabase(context: Context): PostDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PostDatabase::class.java,
                    "PostsDatabase")
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
