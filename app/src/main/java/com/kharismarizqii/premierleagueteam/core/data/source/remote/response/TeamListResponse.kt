package com.kharismarizqii.premierleagueteam.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class TeamListResponse(
    @SerializedName("teams")
    val list: List<TeamResponse>
)
