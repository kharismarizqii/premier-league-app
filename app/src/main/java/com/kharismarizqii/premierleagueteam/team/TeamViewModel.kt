package com.kharismarizqii.premierleagueteam.team

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import com.kharismarizqii.premierleagueteam.core.domain.usecase.TeamUseCase

class TeamViewModel @ViewModelInject constructor(teamUseCase: TeamUseCase) : ViewModel() {
    val team = LiveDataReactiveStreams.fromPublisher(teamUseCase.getListTeam())
}