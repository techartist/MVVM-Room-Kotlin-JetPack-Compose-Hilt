package com.welsh.disneycodechallenge_kristywelsh.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "guest")
class Guest(@field:PrimaryKey
           @field:ColumnInfo(name = "Guest Name")
           val name: String, val hasReservation: Boolean, val selected: Boolean
)
