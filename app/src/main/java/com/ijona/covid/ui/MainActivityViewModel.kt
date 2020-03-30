package com.ijona.covid.ui

import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ijona.covid.BuildConfig
import com.ijona.covid.data.database.model.Area
import com.ijona.covid.data.repository.Repo
import com.mapbox.geojson.Feature
import kotlinx.coroutines.*
import retrofit2.HttpException
import timber.log.Timber
import java.util.*
import javax.net.ssl.HttpsURLConnection
import kotlin.concurrent.fixedRateTimer

class MainActivityViewModel(val repo: Repo) : ViewModel() {



    var coronaLiveData = MediatorLiveData<List<Feature>>()
    private var coronaData: MutableLiveData<List<Feature>> = MutableLiveData()

    var confirmedCaseLiveData = MediatorLiveData<List<Area>>()
    private var confirmCase: MutableLiveData<List<Area>> = MutableLiveData()

    private val interval = 10L

    private var timer: Timer? = null


    init {
        refreshData()
    }

    fun refreshData() {
        timer = fixedRateTimer("referesh", false, 0L, interval * 60 * 1000) {
            coronaDataSource()
        }
    }

    val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        handleError(throwable)
    }


    private fun handleError(throwable: Throwable) {
        try {
            Timber.e(throwable.message)
        } catch (e: Exception) {

        }
        if (throwable is HttpException) {
            val error = (throwable as HttpException)
            when (error.code()) {
                HttpsURLConnection.HTTP_UNAUTHORIZED -> Timber.d("Unauthorised User")
                HttpsURLConnection.HTTP_FORBIDDEN -> Timber.d("Request Forbidden")
                HttpsURLConnection.HTTP_INTERNAL_ERROR -> Timber.d("Internal Server Error")
                HttpsURLConnection.HTTP_BAD_REQUEST -> Timber.d("Bad Request")
                else -> Timber.d(error.localizedMessage)
            }
        } else {
            if (BuildConfig.DEBUG)
                Timber.d((throwable.localizedMessage))
            else
                Timber.d(("Something went wrong!!"))
        }
    }


    fun coronaDataSource() {

        viewModelScope.launch {
            val result = async {
                repo.fetchCovidDataFromBingAPiAndSaveToDb(
                    viewModelScope.coroutineContext,
                    true
                )
            }
            result.await()
            confirmCase.postValue(repo.fetchAllBingCovidAreaByAreaParentId("world"))
            repo.buildLocationData(this.coroutineContext)
        }

        viewModelScope.launch(Dispatchers.Main) {
            confirmedCaseLiveData.removeSource(confirmCase)
            coronaLiveData.removeSource(repo.coronaLiveData)
            coronaLiveData.addSource(repo.coronaLiveData) {
                coronaLiveData.value = it
            }
            confirmedCaseLiveData.addSource(confirmCase) {
                confirmedCaseLiveData.value = it
            }
        }

    }

    override fun onCleared() {
        timer?.cancel()
        super.onCleared()
    }
}