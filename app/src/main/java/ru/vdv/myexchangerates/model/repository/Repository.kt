package ru.vdv.myexchangerates.model.repository

import ru.vdv.myexchangerates.domain.CallBack
import ru.vdv.myexchangerates.domain.ExchangeRates

class Repository : IRepository {
    override fun getData(callBack: CallBack<ExchangeRates>) {
        TODO("Not yet implemented")
    }
}