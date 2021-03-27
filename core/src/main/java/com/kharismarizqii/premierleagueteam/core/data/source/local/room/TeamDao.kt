package com.kharismarizqii.premierleagueteam.core.data.source.local.room

import androidx.room.*
import com.kharismarizqii.premierleagueteam.core.data.source.local.entity.TeamEntity
import io.reactivex.Completable
import io.reactivex.Flowable

@Dao
interface TeamDao {

    @Query("SELECT * FROM team")
    fun getListTeam(): Flowable<List<TeamEntity>>

    @Query("SELECT * FROM team where is_favorite = 1")
    fun getFavoriteTeam(): Flowable<List<TeamEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertListTeam(team: List<TeamEntity>): Completable

    @Update
    fun updateFavoriteTeam(team: TeamEntity)
}