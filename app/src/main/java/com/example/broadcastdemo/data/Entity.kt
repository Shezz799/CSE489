package com.example.broadcastdemo.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "entities")
data class GeoEntity(
    @PrimaryKey
    val id: Int = 0,
    val title: String,
    val lat: Double,
    val lon: Double,
    val image: String
)

data class ApiResponse(
    val id: Int?,
    val message: String?
)
