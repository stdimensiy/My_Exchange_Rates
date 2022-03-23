package ru.vdv.myexchangerates.domain

import ru.vdv.myexchangerates.domain.valutes.Currency

data class PresentExchangeRates(
    val date: String? = null,
    val previousDate: String? = null,
    val previousURL: String? = null,
    val timestamp: String? = null,
    val valute: List<Currency>
)
