package com.kharismarizqii.premierleagueteam.di

import com.kharismarizqii.premierleagueteam.core.domain.usecase.TeamUseCase
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@EntryPoint
@InstallIn(ApplicationComponent::class)
interface FavoriteModuleDependencies {
    fun teamUseCase() : TeamUseCase
}