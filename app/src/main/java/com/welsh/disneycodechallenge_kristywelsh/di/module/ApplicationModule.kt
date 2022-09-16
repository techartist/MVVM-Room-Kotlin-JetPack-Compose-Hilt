package com.welsh.disneycodechallenge_kristywelsh.di.module

import android.content.Context
import com.welsh.disneycodechallenge_kristywelsh.room.GuestDao
import com.welsh.disneycodechallenge_kristywelsh.room.GuestDatabase
import com.welsh.disneycodechallenge_kristywelsh.room.GuestRespository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {



    @Provides
    @Singleton
    fun providesDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default

    @Provides
    @Singleton
    fun providesIoDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @Provides
    @Singleton
    fun providesMainDispatcher(): CoroutineDispatcher = Dispatchers.Main

}