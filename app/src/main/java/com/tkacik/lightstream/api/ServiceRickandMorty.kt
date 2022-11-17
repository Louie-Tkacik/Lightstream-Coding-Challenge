package com.tkacik.lightstream.api



import com.tkacik.lightstream.model.CharResult
import com.tkacik.lightstream.model.CharacterRM
import com.tkacik.lightstream.model.Location
import com.tkacik.lightstream.model.LocationResult
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceRickandMorty  {


    @GET("character")
    fun getCharacters(
        @Query("q") url: String = "character"
    ): Single<CharacterRM>

    @GET("location")
    fun getLocation(
        @Query("q") url: String = "location"
    ): Single<Location>
}