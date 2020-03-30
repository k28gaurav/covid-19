package com.ijona.covid.data.database.model

import android.os.Parcelable
import android.telecom.Call
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CovidChartModel(
    @SerializedName("features") val feature: List<CoronaItem>
): Parcelable

@Parcelize
data class CoronaItem(
    @SerializedName("items") val item: CoronaEntity
):Parcelable

@Parcelize
@Entity(tableName = "corona_entity")
data class CoronaEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "country")
    @SerializedName("Country_Region") val country: String,

    @ColumnInfo(name = "confirmed")
    @SerializedName("ConfirmedNumer") val confirmedNo: Int ,

    @ColumnInfo(name = "death")
    @SerializedName("DeathsNumber")val deathNo: Int ,

    @ColumnInfo(name = "recovered")
    @SerializedName("RecoveredNumber") val recovered: Int,

    @ColumnInfo(name = "latitude")
    @SerializedName("latitude")val latitude: Double ,

    @ColumnInfo(name = "longitude")
    @SerializedName("longitude")val longitude: Double

):Parcelable