package com.example.maskinfokotlin.model

import com.squareup.moshi.Json

data class Store(
    @field:Json(name = "addr")
    var addr: String,
    @field:Json(name = "code")
    var code: String,
    @field:Json(name = "created_at")
    var createdAt: String,
    var lat: Double,
    var lng: Double,
    var name: String,
    @field:Json(name = "remain_stat")
    var remainStat: String,
    @field:Json(name = "stock_at")
    var stockAt: String,
    var type: String,
)