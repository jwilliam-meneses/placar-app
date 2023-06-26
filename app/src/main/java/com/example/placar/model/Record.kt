package com.example.placar.model

import java.io.Serializable

data class Record(
    val matchName: String,
    var teamName1: String,
    var teamName2: String,
    var sets: Number = 3,
    var pointsPerSet: Number = 15,
    var setsTeam1: Number = 0,
    var setsTeam2: Number = 0,
    var pointsTeam1: Number = 0,
    var pointsTeam2: Number = 0,
    var dateTime: String
): Serializable
