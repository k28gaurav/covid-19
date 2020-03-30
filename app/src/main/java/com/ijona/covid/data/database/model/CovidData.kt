package com.ijona.covid.data.database.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "covid_area")
data class Area(

    @PrimaryKey
    @ColumnInfo(name = "id")
    @SerializedName("id") val id: String,

    @ColumnInfo(name = "display_name")
    @SerializedName("displayName") val displayName: String,

    @ColumnInfo(name = "total_confirmed")
    @SerializedName("totalConfirmed") val totalConfirmed: Long,

    @ColumnInfo(name = "total_deaths")
    @SerializedName("totalDeaths") val totalDeaths: Long,

    @ColumnInfo(name = "total_recovered")
    @SerializedName("totalRecovered") val totalRecovered: Long,

    @ColumnInfo(name = "last_update")
    @SerializedName("lastUpdated") val lastUpdated: String?,

    @ColumnInfo(name = "latitude")
    @SerializedName("lat") val latitude: Double?,

    @ColumnInfo(name = "longitude")
    @SerializedName("longitude") val longitude: Double?,

    @ColumnInfo(name = "parent_id")
    @SerializedName("parentId") val parentId: String?
): Parcelable {
    @Ignore
    @SerializedName("areas") var areas: List<Area>? = null
}



