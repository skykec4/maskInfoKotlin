package com.example.maskinfokotlin.di.module

import com.example.maskinfokotlin.repository.MaskService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Inject


@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {

    @Provides
    fun provideMaskService():MaskService{
        val retrofit = Retrofit.Builder()
            .baseUrl(MaskService.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        return retrofit.create(MaskService::class.java)
    }
}