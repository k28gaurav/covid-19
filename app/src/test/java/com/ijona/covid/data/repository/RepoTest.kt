package com.ijona.covid.data.repository

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.google.gson.Gson
import com.ijona.covid.data.database.AppDatabase
import com.ijona.covid.data.database.dao.CoronaEntityDao
import com.ijona.covid.data.network.NetworkConstant
import com.ijona.covid.data.network.category.ApiService
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [28], manifest = Config.NONE)
class RepoTest {

    lateinit var database: AppDatabase
    lateinit var apiService: ApiService
    lateinit var dao: CoronaEntityDao
    lateinit var repo: Repo

    @Before
    fun setup() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        database = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).allowMainThreadQueries().build()
        dao = database.coronaDao()
        apiService = Retrofit.Builder().baseUrl(NetworkConstant.BaseUrl).addConverterFactory(GsonConverterFactory.create(
            Gson()
        )).build().create(ApiService::class.java)
        repo = Repo(apiService, dao)
    }


    @Test
    fun  testBingApiRetrieveAndSave() {
        runBlocking {
           /* val job = launch {
                repo.fetchAllBingCovidArea().collect {
                    //assert(it.isNotEmpty())
                    println("Total Areas: ${it.size}")
                    if(it.isNotEmpty()) {
                        this.cancel()
                    }
                }
            }*/
            repo.fetchCovidDataFromBingAPiAndSaveToDb(Dispatchers.IO, true)
        }
    }

    /*@Test
    fun  test {
        runBlocking {
            repo.fetchCovidDataFromBingAPiAndSaveToDb()
            val areas = repo.fetchAllBingCovidArea()
            assert(areas.isNotEmpty())
            println("Total Areas: ${areas.size}")
        }
    }*/


    @After
    @Throws(IOException::class)
    fun closeDb() {
        database.close()
    }
}