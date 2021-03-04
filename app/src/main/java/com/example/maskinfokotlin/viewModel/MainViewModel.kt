package com.example.maskinfokotlin.viewModel

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.maskinfokotlin.model.Store
import com.example.maskinfokotlin.repository.MaskService
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainViewModel @ViewModelInject constructor(
    private val service: MaskService,
    private val fusedLocationClient: FusedLocationProviderClient
) : ViewModel() {
    val TAG = ViewModel::class.java.simpleName
    val itemLiveData = MutableLiveData<List<Store>>()
    val loadingLiveData = MutableLiveData<Boolean>()


    init {
        fetchStoreInfo()
//        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
    }


    @SuppressLint("MissingPermission")
    fun fetchStoreInfo() {
        loadingLiveData.value = true

        fusedLocationClient.lastLocation.addOnSuccessListener { location ->

            location?.let {
                viewModelScope.launch {
                    val storeInfo = service.fetchStoreInfo()

                    itemLiveData.value = storeInfo.stores.filter { store ->
                        store.remainStat != null
                    }
                    Log.d(TAG, "fetchStoreInfo: ${storeInfo.stores[0]}")
                    loadingLiveData.value = false
                }
            }
        }
    }
}

