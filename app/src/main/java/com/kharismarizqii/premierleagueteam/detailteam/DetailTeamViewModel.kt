package com.kharismarizqii.premierleagueteam.detailteam

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.kharismarizqii.premierleagueteam.core.domain.model.Team
import com.kharismarizqii.premierleagueteam.core.domain.usecase.TeamUseCase

class DetailTeamViewModel @ViewModelInject constructor(private val teamUseCase: TeamUseCase) :
    ViewModel() {
    fun setFavoriteTeam(team: Team, state: Boolean) {
        teamUseCase.setFavoriteTeam(team, state)
    }
}