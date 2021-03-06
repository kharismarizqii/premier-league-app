package com.kharismarizqii.premierleagueteam.core.domain.usecase

import com.kharismarizqii.premierleagueteam.core.data.Resource
import com.kharismarizqii.premierleagueteam.core.domain.model.Team
import com.kharismarizqii.premierleagueteam.core.domain.repository.ITeamRepository
import io.reactivex.Flowable
import javax.inject.Inject

class TeamInteractor @Inject constructor(private val teamRepository: ITeamRepository): TeamUseCase {
    override fun getListTeam(): Flowable<Resource<List<Team>>> = teamRepository.getListTeam()
    override fun getFavoriteTeam(): Flowable<List<Team>> = teamRepository.getFavoriteTeam()
    override fun setFavoriteTeam(team: Team, state: Boolean) {
        teamRepository.setFavoriteTeam(team, state)
    }
}