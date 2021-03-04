package com.kharismarizqii.premierleagueteam.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class TeamResponse(
    @SerializedName("idTeam")
    val id: String,
    @SerializedName("strTeam")
    val name: String,
    @SerializedName("strDescriptionEN")
    val desc: String,
    @SerializedName("intFormedYear")
    val formedYear: String,
    @SerializedName("strTeamBadge")
    val badgeUrl: String,
    @SerializedName("strTeamJersey")
    val jerseyUrl: String,
    @SerializedName("strStadium")
    val stadiumName: String,
    @SerializedName("strStadiumThumb")
    val stadiumThumbUrl: String,
    @SerializedName("strStadiumDescription")
    val stadiumDesc: String,
    @SerializedName("strStadiumLocation")
    val stadiumLocation: String,
    @SerializedName("intStadiumCapacity")
    val stadiumCapacity: String
)
