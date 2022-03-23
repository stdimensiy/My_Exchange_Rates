package ru.vdv.myexchangerates.model.repository

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.vdv.myexchangerates.domain.CallBack
import ru.vdv.myexchangerates.domain.ExchangeRates
import ru.vdv.myexchangerates.domain.PresentExchangeRates
import ru.vdv.myexchangerates.domain.Valute
import ru.vdv.myexchangerates.domain.valutes.Currency
import ru.vdv.myexchangerates.model.api.IAPIDailyRuService
import ru.vdv.myexchangerates.model.retrofit.Common
import kotlin.reflect.full.memberProperties

class Repository : IRepository {
    private val networkServiceDaily: IAPIDailyRuService = Common.retrofitService
    override fun getData(callBack: CallBack<PresentExchangeRates>) {
        networkServiceDaily.getListExchangeRates().enqueue(object : Callback<ExchangeRates> {
            override fun onResponse(call: Call<ExchangeRates>, response: Response<ExchangeRates>) {
                response.body()?.let {
                    //обработка ответа
                    val newList: ArrayList<Currency> = arrayListOf()
                    val currentVal = response.body()!!.valute
                    val properties = Valute::class.memberProperties
                    for (property in properties) {
                        newList.add(property.getter.call(currentVal) as Currency)
                    }
                    callBack.onResult(
                        PresentExchangeRates(
                            it.date,
                            it.previousDate,
                            it.previousURL,
                            it.timestamp,
                            newList.toList()
                        )
                    )
                }
            }

            override fun onFailure(call: Call<ExchangeRates>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

}