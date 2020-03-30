package com.ijona.covid.data.network.category

import com.ijona.covid.data.database.model.Area
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {

    @GET
    suspend fun getBingCovidData(@Url url: String = "https://bing.com/covid/data"): Area
}