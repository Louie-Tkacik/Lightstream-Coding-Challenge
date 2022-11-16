package com.tkacik.lightstream.model

import com.google.gson.annotations.SerializedName


data class CharacterRM (

    @SerializedName("info"    ) var info    : Info?              = Info(),
    @SerializedName("results" ) var results : ArrayList<CharResult> = arrayListOf()

)