package com.panassevich.cryptoapp.pojo

import com.google.gson.annotations.SerializedName

data class CoinResponse(
    @SerializedName("Data")
    val data: List<Datum>
)