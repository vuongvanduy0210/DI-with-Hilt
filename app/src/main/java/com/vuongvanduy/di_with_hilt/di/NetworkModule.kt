package com.vuongvanduy.di_with_hilt.di

import com.google.gson.Gson
import com.vuongvanduy.di_with_hilt.common.Config
import com.vuongvanduy.di_with_hilt.data.apis.PostAPI
import com.vuongvanduy.di_with_hilt.data.apis.QuestionAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
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
    @Named("JSonPlaceHolder")
    fun provideRetrofitJSonPlaceHolder(gsonConverterFactory: GsonConverterFactory) : Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(gsonConverterFactory)
            .baseUrl(Config.JsonPlaceHolder)
            .build()
    }

    @Provides
    fun providePostApi(@Named("JSonPlaceHolder") retrofit: Retrofit) :PostAPI {
        return retrofit.create(PostAPI::class.java)
    }

    @Provides
    @Singleton
    @Named("StackOverFlow")
    fun provideRetrofitStackOverFlow(gsonConverterFactory: GsonConverterFactory) : Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(gsonConverterFactory)
            .baseUrl(Config.StackOverFlowUrl)
            .build()
    }

    @Provides
    fun provideQuestionAPI(@Named("StackOverFlow") retrofit: Retrofit): QuestionAPI {
        return retrofit.create(QuestionAPI::class.java)
    }
}