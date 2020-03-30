package com.ijona.covid.data.repository

import androidx.lifecycle.MutableLiveData
import com.ijona.covid.data.database.dao.CoronaEntityDao
import com.ijona.covid.data.database.model.Area
import com.ijona.covid.data.network.NetworkConstant
import com.ijona.covid.data.network.category.ApiService
import com.mapbox.geojson.Feature

import kotlin.coroutines.CoroutineContext


class Repo(private val apiService: ApiService, private val coronaEntityDao: CoronaEntityDao) {


    private val countryNameList: MutableList<String> = mutableListOf()
    private val longLatList: MutableList<Feature> = mutableListOf()

    val coronaLiveData: MutableLiveData<List<Feature>> = MutableLiveData()
    var isFinished: MutableLiveData<Map<String, Boolean>> = MutableLiveData()

    var confirmCase: MutableLiveData<List<Area>> = MutableLiveData()

    suspend fun fetchCovidDataFromBingAPiAndSaveToDb(coroutineContext: CoroutineContext,
        forceUpdate: Boolean) {

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
}