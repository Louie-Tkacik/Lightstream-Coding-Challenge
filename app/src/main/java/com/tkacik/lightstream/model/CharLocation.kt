package com.tkacik.lightstream.model

import com.google.gson.annotations.SerializedName


data class CharLocation (

    @SerializedName("name" ) var name : String? = null,
    @SerializedName("url"  ) var url  : String? = null

)