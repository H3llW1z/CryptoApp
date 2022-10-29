package com.panassevich.cryptoapp.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.panassevich.cryptoapp.api.ApiFactory
import com.panassevich.cryptoapp.utils.convertTimestampToTime

@Entity(tableName = "full_price_list")
data class CoinPriceInfo(
    @SerializedName("TYPE")
    val type: String? = null,

    @SerializedName("MARKET")
    val market: String? = null,

    @SerializedName("FROMSYMBOL")
    @PrimaryKey
    val fromSymbol: String,

    @SerializedName("TOSYMBOL")
    val toSymbol: String? = null,

    @SerializedName("FLAGS")
    val flags: String? = null,

    @SerializedName("PRICE")
    val price: Double? = null,

    @SerializedName("LASTUPDATE")
    val lastUpdate: Long? = null,

    @SerializedName("MEDIAN")
    val median: Double? = null,

    @SerializedName("LASTVOLUME")
    val lastVolume: Double? = null,

    @SerializedName("LASTVOLUMETO")
    val lastVolumeto: Double? = null,

    @SerializedName("LASTTRADEID")
    val lastTradeId: String? = null,

    @SerializedName("VOLUMEDAY")
    val volumeDay: Double? = null,

    @SerializedName("VOLUMEDAYTO")
    val volumeDayTo: Double? = null,

    @SerializedName("VOLUME24HOUR")
    val volume24Hour: Double? = null,

    @SerializedName("VOLUME24HOURTO")
    val volume24HourTo: Double? = null,

    @SerializedName("OPENDAY")
    val openDay: Double? = null,

    @SerializedName("HIGHDAY")
    val highDay: Double? = null,

    @SerializedName("LOWDAY")
    val lowDay: Double? = null,

    @SerializedName("OPEN24HOUR")
    val open24hour: Double? = null,

    @SerializedName("HIGH24HOUR")
    val high24hour: Double? = null,

    @SerializedName("LOW24HOUR")
    val low24hour: Double? = null,

    @SerializedName("LASTMARKET")
    val lastMarket: String? = null,

    @SerializedName("VOLUMEHOUR")
    val volumeHour: Double? = null,

    @SerializedName("VOLUMEHOURTO")
    val volumeHourTo: Double? = null,

    @SerializedName("OPENHOUR")
    val openHour: Double? = null,

    @SerializedName("HIGHHOUR")
    val highHour: Double? = null,

    @SerializedName("LOWHOUR")
    val lowHour: Double? = null,

    @SerializedName("TOPTIERVOLUME24HOUR")
    val topTierVolume24Hour: Double? = null,

    @SerializedName("TOPTIERVOLUME24HOURTO")
    val topTierVolume24HourTo: Double? = null,

    @SerializedName("CHANGE24HOUR")
    val change24hour: Double? = null,

    @SerializedName("CHANGEPCT24HOUR")
    val changepct24hour: Double? = null,

    @SerializedName("CHANGEDAY")
    val changeDay: Double? = null,

    @SerializedName("CHANGEPCTDAY")
    val changepctday: Double? = null,

    @SerializedName("CHANGEHOUR")
    val changeHour: Double? = null,

    @SerializedName("CHANGEPCTHOUR")
    val changepcthour: Double? = null,

    @SerializedName("CONVERSIONTYPE")
    val conversionType: String? = null,

    @SerializedName("CONVERSIONSYMBOL")
    val conversionSymbol: String? = null,

    @SerializedName("SUPPLY")
    val supply: Int? = null,

    @SerializedName("MKTCAP")
    val mktcap: Double? = null,

    @SerializedName("MKTCAPPENALTY")
    val mktcappenalty: Int? = null,

    @SerializedName("CIRCULATINGSUPPLY")
    val circulatingSupply: Int? = null,

    @SerializedName("CIRCULATINGSUPPLYMKTCAP")
    val circulatingSupplymktcap: Double? = null,

    @SerializedName("TOTALVOLUME24H")
    val totalVolume24h: Double? = null,

    @SerializedName("TOTALVOLUME24HTO")
    val totalVolume24hto: Double? = null,

    @SerializedName("TOTALTOPTIERVOLUME24H")
    val totalTopTierVolume24h: Double? = null,

    @SerializedName("TOTALTOPTIERVOLUME24HTO")
    val totalTopTierVolume24hTo: Double? = null,

    @SerializedName("IMAGEURL")
    val imageUrl: String? = null
) {
    fun getFormattedTime(): String {
        return convertTimestampToTime(lastUpdate)
    }

    fun getFullImageUrl(): String {
        return ApiFactory.BASE_IMAGE_URL + imageUrl
    }
}

