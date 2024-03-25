package com.example.nfl_teams_v2

data class NFLTeam(
    val teamCode: String,
    val teamName: String,
    val teamLogo: String,
    val conference: String,
    val division: String,
    val stadiumName: String,
    val latitude: Double,
    val longitude: Double
)
