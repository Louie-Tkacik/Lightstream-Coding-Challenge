package com.tkacik.lightstream.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Info (

    @SerializedName("count" ) var count : Int?    = null,
    @SerializedName("pages" ) var pages : Int?    = null,
    @SerializedName("next"  ) var next  : String? = null,
    @SerializedName("prev"  ) var prev  : String? = null

) : Parcelable