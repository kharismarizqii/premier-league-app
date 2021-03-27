package com.kharismarizqii.premierleagueteam.favorite

import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import com.kharismarizqii.premierleagueteam.core.domain.usecase.TeamUseCase

class FavoriteViewModel (teamUseCase: TeamUseCase): ViewModel() {
    val team = LiveDataReactiveStreams.fromPublisher(teamUseCase.getFavoriteTeam())
}