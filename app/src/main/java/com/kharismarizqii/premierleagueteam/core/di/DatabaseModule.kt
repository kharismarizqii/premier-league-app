package com.kharismarizqii.premierleagueteam.core.di

import android.content.Context
import androidx.room.Room
import com.kharismarizqii.premierleagueteam.core.data.source.local.room.TeamDao
import com.kharismarizqii.premierleagueteam.core.data.source.local.room.TeamDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(context: Context): TeamDatabase = Room.databaseBuilder(
        context,
        TeamDatabase::class.java,
        "Team.db"
    ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideTeamDao(database: TeamDatabase): TeamDao = database.teamDao()
}