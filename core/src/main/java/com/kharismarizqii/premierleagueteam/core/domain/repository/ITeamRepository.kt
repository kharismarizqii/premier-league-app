package com.kharismarizqii.premierleagueteam.core.domain.repository

import com.kharismarizqii.githubuserapp.core.data.Resource
import com.kharismarizqii.premierleagueteam.core.domain.model.Team
import io.reactivex.Flowable

interface ITeamRepository {
    fun getListTeam(): Flowable<Resource<List<Team>>>

    fun getFavoriteTeam(): Flowable<List<Team>>

    fun setFavoriteTeam(team: Team, state: Boolean)
}