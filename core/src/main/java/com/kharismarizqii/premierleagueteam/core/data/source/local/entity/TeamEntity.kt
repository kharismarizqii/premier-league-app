package com.kharismarizqii.premierleagueteam.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "team")
data class TeamEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    val id: String,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "description")
    val desc: String,
    @ColumnInfo(name = "formed_year")
    val formedYear: String,
    @ColumnInfo(name = "badge_url")
    val badgeUrl: String,
    @ColumnInfo(name = "jersey_url")
    val jerseyUrl: String,
    @ColumnInfo(name = "stadium_name")
    val stadiumName: String,
    @ColumnInfo(name = "stadium_thumb")
    val stadiumThumbUrl: String,
    @ColumnInfo(name = "stadium_desc")
    val stadiumDesc: String,
    @ColumnInfo(name = "stadium_loc")
    val stadiumLocation: String,
    @ColumnInfo(name = "stadium_capacity")
    val stadiumCapacity: String,
    @ColumnInfo(name = "is_favorite")
    var isFavorite: Boolean = false
)
