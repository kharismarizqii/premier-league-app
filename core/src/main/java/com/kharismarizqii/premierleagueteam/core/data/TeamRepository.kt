package com.kharismarizqii.premierleagueteam.core.data

import android.util.Log
import com.kharismarizqii.githubuserapp.core.data.NetworkBoundResource
import com.kharismarizqii.githubuserapp.core.data.Resource
import com.kharismarizqii.premierleagueteam.core.data.source.local.LocalDataSource
import com.kharismarizqii.premierleagueteam.core.data.source.local.entity.TeamEntity
import com.kharismarizqii.premierleagueteam.core.data.source.remote.RemoteDataSource
import com.kharismarizqii.premierleagueteam.core.data.source.remote.network.ApiResponse
import com.kharismarizqii.premierleagueteam.core.data.source.remote.response.TeamResponse
import com.kharismarizqii.premierleagueteam.core.domain.model.Team
import com.kharismarizqii.premierleagueteam.core.domain.repository.ITeamRepository
import com.kharismarizqii.premierleagueteam.core.utils.AppExecutors
import com.kharismarizqii.premierleagueteam.core.utils.DataMapper
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TeamRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : ITeamRepository {
    override fun getListTeam(): Flowable<Resource<List<Team>>> =
        object : NetworkBoundResource<List<Team>, List<TeamResponse>>(appExecutors){
            override fun loadFromDB(): Flowable<List<Team>> {
                return localDataSource.getListTeam().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Team>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): Flowable<ApiResponse<List<TeamResponse>>> {
                return remoteDataSource.getTeamList()
            }

            override fun saveCallResult(data: List<TeamResponse>) {
                val teamList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertListTeam(teamList)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe()
            }

        }.asFlowable()

    override fun getFavoriteTeam(): Flowable<List<Team>> {
        return localDataSource.getFavoriteTeam().map { DataMapper.mapEntitiesToDomain(it) }
    }

    override fun setFavoriteTeam(team: Team, state: Boolean) {
        Log.e("TeamRepository", "setFavoriteTeam: state ${team.isFavorite}, newState: $state ")
        val teamEntity = DataMapper.mapDomainToEntity(team)
        appExecutors.diskIO().execute { localDataSource.setFavoriteTeam(teamEntity, state) }
    }
}