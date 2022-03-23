package ru.vdv.myexchangerates.domain.valutes

import com.google.gson.annotations.SerializedName

open class Currency {
    @SerializedName("CharCode")
    var charCode: String? = null
}