package com.welsh.disneycodechallenge_kristywelsh.di.module

import android.content.Context
import com.welsh.disneycodechallenge_kristywelsh.room.GuestDao
import com.welsh.disneycodechallenge_kristywelsh.room.GuestDatabase
import com.welsh.disneycodechallenge_kristywelsh.room.GuestRespository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class) // this is new
object RepositoryModule {

    @Provides
    fun provideGuestDatabase(
        @ApplicationContext context: Context
    ): GuestDatabase = GuestDatabase.getDatabase(context)

    @Provides
    fun provideGuestDao(database:GuestDatabase): GuestDao {
        return database.guestDao()
    }

    @Provides
    fun provideGuestRepository(guestDao: GuestDao) = GuestRespository(guestDao)




}