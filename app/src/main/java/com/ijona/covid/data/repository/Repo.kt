package com.ijona.covid.data.repository

import androidx.lifecycle.MutableLiveData
import com.ijona.covid.data.database.dao.CoronaEntityDao
import com.ijona.covid.data.database.model.Area
import com.ijona.covid.data.network.NetworkConstant
import com.ijona.covid.data.network.category.ApiService
import com.mapbox.api.geocoding.v5.GeocodingCriteria
import com.mapbox.api.geocoding.v5.MapboxGeocoding
import com.mapbox.api.geocoding.v5.models.GeocodingResponse
import com.mapbox.geojson.Feature
import com.mapbox.geojson.Point
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

import kotlin.coroutines.CoroutineContext


class Repo(private val apiService: ApiService, private val coronaEntityDao: CoronaEntityDao) {


    private val countryNameList: MutableList<String> = mutableListOf()
    private val longLatList: MutableList<Feature> = mutableListOf()

    val coronaLiveData: MutableLiveData<List<Feature>> = MutableLiveData()

    var confirmCase: MutableLiveData<List<Area>> = MutableLiveData()

    suspend fun fetchCovidDataFromBingAPiAndSaveToDb(
        coroutineContext: CoroutineContext,
        forceUpdate: Boolean
    ) {

        countryNameList.clear()
        longLatList.clear()


        val respResult = runCatching {
            apiService.getBingCovidData(NetworkConstant.bingUrl)
        }

        if (respResult.isSuccess) {
            val resp = respResult.getOrNull()
            resp?.let {
                val areaList = mutableListOf<Area>()
                buildAreaListRecursive(areaList, it)
                coronaEntityDao.saveAllBingAreaDataForCorona(areaList)
            }
        } else {

        }
    }


    private fun buildAreaListRecursive(areaList: MutableList<Area>, area: Area) {
        areaList.add(area)
        area.areas?.forEach {
            buildAreaListRecursive(areaList, it)
        }
    }

    suspend fun fetchAllBingCovidAreaByAreaParentId(parentId: String): List<Area> =
        coronaEntityDao.fetchAllBingCovidAreaByAreaParentId(parentId)


    suspend fun buildLocationData(coroutineContext: CoroutineContext) {
        CoroutineScope(coroutineContext).launch {
            val data = async {  fetchAllBingCovidAreaByAreaParentId("india") }
           val result = data.await()

               val latlist = async {  result.forEach {
                   longLatList.add(
                       Feature.fromGeometry(
                           Point.fromLngLat(
                               it.latitude ?: 39.913818, it.longitude
                                   ?: 116.363625
                           )
                       )
                   )
               }

                   coronaLiveData.postValue(longLatList)
            }

             latlist.await()
        }


    }


    private fun getLngLatFromCountryName(countryName: String) {
        val client = MapboxGeocoding.builder()
            .accessToken(NetworkConstant.MAPBOX_TOKEN)
            .query(countryName)
            .geocodingTypes(GeocodingCriteria.TYPE_COUNTRY)
            .mode(GeocodingCriteria.MODE_PLACES)
            .build()

        client.enqueueCall(object : Callback<GeocodingResponse> {
            override fun onFailure(call: Call<GeocodingResponse>, t: Throwable) {
                Timber.e("onFailure ${t.localizedMessage}")
            }

            override fun onResponse(
                call: Call<GeocodingResponse>,
                response: Response<GeocodingResponse>
            ) {

                if (response.body() != null) {
                    val results = response.body()!!.features()
                    if (results.size > 0) {

                        val feature = results[0]


                        countryNameList.add(countryName)

                    }
                }
            }
        }
        )
    }


    private suspend fun buildData(): MutableList<Feature> {
        val featureList: MutableList<Feature> = mutableListOf()
        var confirmedCount = 0
        var deathCount = 0


        featureList.add(longLatList[0])

        return featureList

    }


}