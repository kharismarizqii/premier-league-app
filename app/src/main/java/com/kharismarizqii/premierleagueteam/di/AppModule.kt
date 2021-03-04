package com.kharismarizqii.premierleagueteam.di

import com.kharismarizqii.premierleagueteam.core.domain.usecase.TeamInteractor
import com.kharismarizqii.premierleagueteam.core.domain.usecase.TeamUseCase
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {
    @Binds
    abstract fun provideTeamUseCase(teamInteractor: TeamInteractor): TeamUseCase
}