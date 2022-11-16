package com.tkacik.lightstream.api

import com.tkacik.lightstream.model.CharResult
import com.tkacik.lightstream.model.CharacterRM
import com.tkacik.lightstream.model.LocationResult
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class RepositoryRickandMorty @Inject constructor(
    private val serviceRickandMorty: ServiceRickandMorty
){
    fun getCharacterRM(
    url: String
    ): Single<CharacterRM> = serviceRickandMorty.getCharacters(url)

    fun getLocation(
        url: String
    ): Single<LocationResult> = serviceRickandMorty.getLocation(url)
}