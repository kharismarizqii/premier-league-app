package com.kharismarizqii.premierleagueteam.core.data.source.remote

import android.annotation.SuppressLint
import android.util.Log
import com.kharismarizqii.premierleagueteam.core.data.source.remote.network.ApiResponse
import com.kharismarizqii.premierleagueteam.core.data.source.remote.network.ApiService
import com.kharismarizqii.premierleagueteam.core.data.source.remote.response.TeamResponse
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val apiService: ApiService) {
    @SuppressLint("CheckResult")
    fun getTeamList(): Flowable<ApiResponse<List<TeamResponse>>> {
        val resultData = PublishSubject.create<ApiResponse<List<TeamResponse>>>()

        val client = apiService.getListTeam()

        client.subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .take(1)
                .subscribe({ response ->
                    val dataArray = response.list
                    resultData.onNext(if (dataArray.isNotEmpty()) ApiResponse.Success(dataArray) else ApiResponse.Empty)
                }, { error ->
                    resultData.onNext(ApiResponse.Error(error.message.toString()))
                    Log.e("RemoteDataSource", error.toString())
                })

        return resultData.toFlowable(BackpressureStrategy.BUFFER)
    }
}