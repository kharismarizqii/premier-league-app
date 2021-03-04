package com.kharismarizqii.premierleagueteam.core.domain.usecase

import com.kharismarizqii.githubuserapp.core.data.Resource
import com.kharismarizqii.premierleagueteam.core.domain.model.Team
import io.reactivex.Flowable

interface TeamUseCase {
    fun getListTeam(): Flowable<Resource<List<Team>>>
}