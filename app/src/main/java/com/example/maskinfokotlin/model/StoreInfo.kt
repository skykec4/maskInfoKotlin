package com.example.maskinfokotlin.model

import com.squareup.moshi.Json

data class StoreInfo(
    var count: Int,
    var stores: List<Store>
)

