package com.tkacik.lightstream.util

import com.tkacik.lightstream.model.Location
import com.tkacik.lightstream.model.LocationResult


sealed class DataStateLocations{
    data class Success(val data: ArrayList<LocationResult>) : DataStateLocations()
    data class Error(val msg: String) : DataStateLocations()
    object Loading : DataStateLocations()
    object Idle : DataStateLocations()
}
