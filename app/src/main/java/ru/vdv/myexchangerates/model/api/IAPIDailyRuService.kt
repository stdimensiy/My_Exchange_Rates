package ru.vdv.myexchangerates.model.api

import retrofit2.Call
import retrofit2.http.GET
import ru.vdv.myexchangerates.domain.ExchangeRates

interface IAPIDailyRuService {
    @GET("daily_json.js")
    fun GetListExchangeRates(): Call<ExchangeRates>
}