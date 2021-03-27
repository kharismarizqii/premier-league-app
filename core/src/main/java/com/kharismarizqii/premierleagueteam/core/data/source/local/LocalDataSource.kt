package com.kharismarizqii.premierleagueteam.core.data.source.local

import android.util.Log
import com.kharismarizqii.premierleagueteam.core.data.source.local.entity.TeamEntity
import com.kharismarizqii.premierleagueteam.core.data.source.local.room.TeamDao
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val teamDao: TeamDao) {
    fun getListTeam() : Flowable<List<TeamEntity>> = teamDao.getListTeam()
    fun insertListTeam(team: List<TeamEntity>) = teamDao.insertListTeam(team)

    fun getFavoriteTeam(): Flowable<List<TeamEntity>> = teamDao.getFavoriteTeam()
    fun setFavoriteTeam(team: TeamEntity, newState: Boolean){
        Log.e("LocalDataSource", "setFavoriteTeam: state ${team.isFavorite}, newState: $newState ")
        team.isFavorite = newState
        teamDao.updateFavoriteTeam(team)
    }
}