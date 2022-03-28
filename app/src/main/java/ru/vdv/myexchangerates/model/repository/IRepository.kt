package ru.vdv.myexchangerates.model.repository

import ru.vdv.myexchangerates.domain.CallBack
import ru.vdv.myexchangerates.domain.ExchangeRates
import ru.vdv.myexchangerates.domain.PresentExchangeRates

interface IRepository {
    fun getData(callBack: CallBack<PresentExchangeRates>)
}