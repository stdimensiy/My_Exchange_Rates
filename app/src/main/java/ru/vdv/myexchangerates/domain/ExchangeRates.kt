package ru.vdv.myexchangerates.domain

import com.google.gson.annotations.SerializedName

data class ExchangeRates(
    @SerializedName("Date")
    val date: String? = null,
    @SerializedName("PreviousDate")
    val previousDate: String? = null,
    @SerializedName("PreviousURL")
    val previousURL: String? = null,
    @SerializedName("Timestamp")
    val timestamp: String? = null,
    @SerializedName("Valute")
    val valute: Valute? = Valute()
)
