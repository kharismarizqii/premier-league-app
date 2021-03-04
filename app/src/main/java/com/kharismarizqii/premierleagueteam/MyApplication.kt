package com.kharismarizqii.premierleagueteam

import android.app.Application
import com.kharismarizqii.premierleagueteam.core.di.CoreComponent
import com.kharismarizqii.premierleagueteam.core.di.DaggerCoreComponent
import com.kharismarizqii.premierleagueteam.di.AppComponent
import com.kharismarizqii.premierleagueteam.di.DaggerAppComponent

open class MyApplication : Application() {
    private val coreComponent: CoreComponent by lazy {
        DaggerCoreComponent.factory().create(applicationContext)
    }

    val appComponent : AppComponent by lazy {
        DaggerAppComponent.factory().create(coreComponent)
    }
}