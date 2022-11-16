package com.tkacik.lightstream.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tkacik.lightstream.api.RepositoryRickandMorty
import com.tkacik.lightstream.model.CharacterRM
import com.tkacik.lightstream.model.Location
import com.tkacik.lightstream.util.DataStateCharacters
import com.tkacik.lightstream.util.DataStateLocations
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class RickandMortyViewModel @Inject constructor(
    private val repositoryRickandMorty: RepositoryRickandMorty
): ViewModel() {
    private var disposable: CompositeDisposable = CompositeDisposable()
    private val dataStateCharacters: MutableLiveData<DataStateCharacters> = MutableLiveData()
    val dataStateCharactersLD: LiveData<DataStateCharacters>
    get() = dataStateCharacters
    private var dataStateLocations: MutableLiveData<DataStateLocations> = MutableLiveData()
    val dataStateLocationsLD: LiveData<DataStateLocations>
    get() = dataStateLocations


    fun loadCharacterList(url: String){
        disposable.add(
            repositoryRickandMorty.getCharacterRM("character")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::characterSuccessRM, this::onError)
        )
    }
    private fun characterSuccessRM(characterRM: CharacterRM){
        val state = characterRM.results?.let {DataStateCharacters.Success(it)}
            ?: DataStateCharacters.Error("No data found")
        dataStateCharacters.value=state
    }


    fun loadLocationList(url: String){
        disposable.add(
            repositoryRickandMorty.getLocation("location")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::locationSuccess, this::onError)
        )
    }
    private fun locationSuccess(location: Location){
        val state = location.results?.let {DataStateLocations.Success(it)}
            ?: DataStateCharacters.Error("No data found")
        dataStateLocations.value=state
    } //TODO: fix this

    private fun onError(throwable: Throwable) {
        val errorMsg = throwable.message ?: "Something went wrong."
        dataStateCharacters.value = DataStateCharacters.Error(errorMsg)
        //Log.d("_log", "this is an error" + throwable.message)
    }
    override fun onCleared() {
        disposable.dispose()
        super.onCleared()
    }

    fun resetState() {
        dataStateLocations.value = DataStateLocations.Idle
        dataStateCharacters.value = DataStateCharacters.Idle

    }