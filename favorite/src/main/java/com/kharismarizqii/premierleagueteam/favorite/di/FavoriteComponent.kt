package com.kharismarizqii.premierleagueteam.favorite.di

import android.content.Context
import com.kharismarizqii.premierleagueteam.di.FavoriteModuleDependencies
import com.kharismarizqii.premierleagueteam.favorite.FavoriteActivity
import dagger.BindsInstance
import dagger.Component

@Component(dependencies = [FavoriteModuleDependencies::class])
interface FavoriteComponent {

    fun inject(activity: FavoriteActivity)

    @Component.Builder
    interface Builder {
        fun context(@BindsInstance context: Context): Builder
        fun appDependencies(mapsModuleDependencies: FavoriteModuleDependencies): Builder
        fun build(): FavoriteComponent
    }
}