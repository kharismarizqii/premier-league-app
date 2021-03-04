package com.kharismarizqii.premierleagueteam.core.data.source.remote.network

import com.kharismarizqii.premierleagueteam.core.data.source.remote.response.TeamListResponse
import com.kharismarizqii.premierleagueteam.core.data.source.remote.response.TeamResponse
import io.reactivex.Flowable
import retrofit2.http.GET

interface ApiService {
    @GET("json/1/search_all_teams.php?l=English%20Premier%20League")
    fun getListTeam(): Flowable<TeamListResponse>
}