package com.ijona.covid.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ijona.covid.data.database.model.Area
import com.ijona.covid.data.database.model.CoronaEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CoronaEntityDao {

    @Query("SELECT * FROM corona_entity")
    fun getAllData(): List<CoronaEntity>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveEntity(t: List<CoronaEntity>): List<Long>

    @Query("DELETE FROM corona_entity")
    suspend fun deleteAllData(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveAllBingAreaDataForCorona(areaList: List<Area>)

    @Query("SELECT * FROM covid_area")
    suspend fun fetchAllBingCovidArea(): List<Area>

    @Query("SELECT * FROM covid_area WHERE parent_id=:parentId")
    suspend fun fetchAllBingCovidAreaByAreaParentId(parentId: String): List<Area>
}