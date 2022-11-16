package com.tkacik.lightstream.model

import com.google.gson.annotations.SerializedName


data class Location (

    @SerializedName("info"    ) var info    : Info?              = Info(),
    @SerializedName("results" ) var results : ArrayList<LocationResult> = arrayListOf()

)