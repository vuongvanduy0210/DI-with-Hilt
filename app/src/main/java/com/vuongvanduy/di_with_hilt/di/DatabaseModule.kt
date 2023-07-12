package com.vuongvanduy.di_with_hilt.di

import android.content.Context
import androidx.room.Room
import com.vuongvanduy.di_with_hilt.data.database.daos.PostDAO
import com.vuongvanduy.di_with_hilt.data.database.database.PostDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun providePostDatabase(@ApplicationContext context: Context): PostDatabase {
        return Room.databaseBuilder(context, PostDatabase::class.java, "app_db").build()
    }

    @Provides
    fun providePostDAO(postDatabase: PostDatabase): PostDAO {
        return postDatabase.postDao()
    }
}