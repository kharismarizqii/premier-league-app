package com.kharismarizqii.premierleagueteam.core.di

import com.kharismarizqii.premierleagueteam.core.data.TeamRepository
import com.kharismarizqii.premierleagueteam.core.domain.repository.ITeamRepository
import dagger.Binds
import dagger.Module

@Module(includes = [NetworkModule::class, DatabaseModule::class])
abstract class RepositoryModule {
    @Binds
    abstract fun provideRepository(teamRepository: TeamRepository): ITeamRepository
}