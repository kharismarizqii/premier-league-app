package com.kharismarizqii.premierleagueteam.core.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kharismarizqii.premierleagueteam.core.domain.usecase.TeamUseCase
import com.kharismarizqii.premierleagueteam.di.AppScope
import com.kharismarizqii.premierleagueteam.team.TeamViewModel
import javax.inject.Inject

@AppScope
class ViewModelFactory @Inject constructor(private val teamUseCase: TeamUseCase) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        when {
            modelClass.isAssignableFrom(TeamViewModel::class.java) -> {
                TeamViewModel(teamUseCase) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }

}