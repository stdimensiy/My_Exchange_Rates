package ru.vdv.myexchangerates.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import java.sql.Timestamp
import java.util.*
import kotlinx.parcelize.Parcelize

@Parcelize
data class ExchangeRates(
    @SerializedName("Date")
    val date: Date,
    @SerializedName("PreviousDate")
    val previousDate: Date,
    @SerializedName("PreviousURL")
    val previousURL: String,
    @SerializedName("Timestamp")
    val timestamp: Timestamp,
    @SerializedName("Valute")
    val valute: List<Valute>
) : Parcelable
