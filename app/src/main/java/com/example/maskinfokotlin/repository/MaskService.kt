package com.example.maskinfokotlin.repository

import com.example.maskinfokotlin.model.StoreInfo
import retrofit2.http.GET

interface MaskService {
    companion object {
        const val BASE_URL = "https://gist.githubusercontent.com/"
    }

    @GET("/junsuk5/bb7485d5f70974deee920b8f0cd1e2f0/raw/063f64d9b343120c2cb01a6555cf9b38761b1d94")
    suspend fun fetchStoreInfo(): StoreInfo
}