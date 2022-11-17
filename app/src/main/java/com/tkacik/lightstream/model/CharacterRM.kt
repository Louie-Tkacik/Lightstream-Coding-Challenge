package com.tkacik.lightstream.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.parcelize.Parcelize

@Parcelize
data class CharacterRM (

    @SerializedName("info"    ) var info    : Info?              = Info(),
    @SerializedName("results" ) var results : ArrayList<CharResult> = arrayListOf()

) : Parcelable