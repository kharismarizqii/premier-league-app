package com.kharismarizqii.premierleagueteam.core.data.source.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kharismarizqii.premierleagueteam.core.data.source.local.entity.TeamEntity
import io.reactivex.Completable
import io.reactivex.Flowable

@Dao
interface TeamDao {

    @Query("SELECT * FROM team")
    fun getListTeam(): Flowable<List<TeamEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertListTeam(team: List<TeamEntity>): Completable
}