package com.vuongvanduy.di_with_hilt.di

import com.google.gson.Gson
import com.vuongvanduy.di_with_hilt.common.Config
import com.vuongvanduy.di_with_hilt.data.apis.PostAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideGsonConvertFactory() : GsonConverterFactory {
        return GsonConverterFactory.create(Gson())
    }

    @Provides
    @Singleton
    fun provideRetrofitStackOverFlow(gsonConverterFactory: GsonConverterFactory) : Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(gsonConverterFactory)
            .baseUrl(Config.StackOverFlowUrl)
            .build()
    }

    @Provides
    fun providePostApi(retrofit: Retrofit) :PostAPI {
        return retrofit.create(PostAPI::class.java)
    }
}