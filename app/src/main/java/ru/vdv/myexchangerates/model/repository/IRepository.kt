package ru.vdv.myexchangerates.model.repository

import ru.vdv.myexchangerates.domain.CallBack
import ru.vdv.myexchangerates.domain.ExchangeRates

interface IRepository {
    fun getData(callBack: CallBack<ExchangeRates>)
}