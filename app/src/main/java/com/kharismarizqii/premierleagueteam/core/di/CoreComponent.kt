package com.kharismarizqii.premierleagueteam.core.di

import android.content.Context
import com.kharismarizqii.premierleagueteam.core.domain.repository.ITeamRepository
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [RepositoryModule::class]
)
interface CoreComponent {
    @Component.Factory
    interface Factory{
        fun create(@BindsInstance context: Context): CoreComponent
    }

    fun provideRepository(): ITeamRepository
}