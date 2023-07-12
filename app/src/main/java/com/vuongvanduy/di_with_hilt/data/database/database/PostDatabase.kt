package com.vuongvanduy.di_with_hilt.data.database.database

import androidx.room.Database
import androidx.room.Entity
import androidx.room.RoomDatabase
import com.vuongvanduy.di_with_hilt.data.database.daos.PostDAO
import com.vuongvanduy.di_with_hilt.data.database.entities.PostEntity

@Database(entities = [PostEntity::class], version = 1)
abstract class PostDatabase : RoomDatabase() {

    abstract fun postDao(): PostDAO
}