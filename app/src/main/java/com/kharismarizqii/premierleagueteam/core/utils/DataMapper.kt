package com.kharismarizqii.premierleagueteam.core.utils

import com.kharismarizqii.premierleagueteam.core.data.source.local.entity.TeamEntity
import com.kharismarizqii.premierleagueteam.core.data.source.remote.response.TeamResponse
import com.kharismarizqii.premierleagueteam.core.domain.model.Team

object DataMapper {
    fun mapResponsesToEntities(input: List<TeamResponse>): List<TeamEntity>{
        val list = ArrayList<TeamEntity>()
        input.map {
            val team = TeamEntity(
                id = it.id,
                name = it.name,
                desc = it.desc,
                formedYear = it.formedYear,
                badgeUrl = it.badgeUrl,
                jerseyUrl = it.jerseyUrl,
                stadiumName = it.stadiumName,
                stadiumThumbUrl = it.stadiumThumbUrl,
                stadiumDesc = it.stadiumDesc,
                stadiumLocation = it.stadiumLocation,
                stadiumCapacity = it.stadiumCapacity
            )
            list.add(team)
        }
        return list
    }

    fun mapEntitiesToDomain(input: List<TeamEntity>): List<Team>{
        val list = ArrayList<Team>()
        input.map {
            val team = Team(
                id = it.id,
                name = it.name,
                desc = it.desc,
                formedYear = it.formedYear,
                badgeUrl = it.badgeUrl,
                jerseyUrl = it.jerseyUrl,
                stadiumName = it.stadiumName,
                stadiumThumbUrl = it.stadiumThumbUrl,
                stadiumDesc = it.stadiumDesc,
                stadiumLocation = it.stadiumLocation,
                stadiumCapacity = it.stadiumCapacity
            )
            list.add(team)
        }
        return list
    }
}