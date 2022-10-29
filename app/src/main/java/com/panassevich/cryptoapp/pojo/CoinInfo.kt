package com.panassevich.cryptoapp.pojo


import com.google.gson.annotations.SerializedName


data class CoinInfo(
    @SerializedName("Name")
    val name: String
)