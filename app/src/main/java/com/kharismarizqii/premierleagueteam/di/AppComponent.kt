package com.kharismarizqii.premierleagueteam.di

import com.kharismarizqii.premierleagueteam.team.MainActivity
import com.kharismarizqii.premierleagueteam.core.di.CoreComponent
import com.kharismarizqii.premierleagueteam.detailteam.DetailTeamActivity
import dagger.Component

@AppScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [AppModule::class]
)
interface AppComponent {
    @Component.Factory
    interface Factory{
        fun create(coreComponent: CoreComponent): AppComponent
    }

    fun inject(activity: MainActivity)
    fun inject(activity: DetailTeamActivity)
}