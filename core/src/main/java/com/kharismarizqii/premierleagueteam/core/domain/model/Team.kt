package com.kharismarizqii.premierleagueteam.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Team(
    val id: String,
    val name: String,
    val desc: String,
    val formedYear: String,
    val badgeUrl: String,
    val jerseyUrl: String,
    val stadiumName: String,
    val stadiumThumbUrl: String,
    val stadiumDesc: String,
    val stadiumLocation: String,
    val stadiumCapacity: String,
    val isFavorite: Boolean
) : Parcelable