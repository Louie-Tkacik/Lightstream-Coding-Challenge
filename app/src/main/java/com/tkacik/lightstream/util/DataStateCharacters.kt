package com.tkacik.lightstream.util

import com.tkacik.lightstream.model.CharResult
import com.tkacik.lightstream.model.CharacterRM


sealed class DataStateCharacters {
    data class Success(val data: ArrayList<CharResult>) : DataStateCharacters()
    data class Error(val msg: String) : DataStateCharacters()
    object Loading : DataStateCharacters()
    object Idle : DataStateCharacters()
}