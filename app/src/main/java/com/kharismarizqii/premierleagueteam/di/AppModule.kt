package com.kharismarizqii.premierleagueteam.di

import com.kharismarizqii.premierleagueteam.core.domain.usecase.TeamInteractor
import com.kharismarizqii.premierleagueteam.core.domain.usecase.TeamUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
abstract class AppModule {
    @Binds
    abstract fun provideTeamUseCase(teamInteractor: TeamInteractor): TeamUseCase
}