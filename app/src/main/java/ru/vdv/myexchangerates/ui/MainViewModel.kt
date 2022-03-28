package ru.vdv.myexchangerates.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.vdv.myexchangerates.domain.CallBack
import ru.vdv.myexchangerates.domain.PresentExchangeRates
import ru.vdv.myexchangerates.model.repository.Repository

class MainViewModel : ViewModel() {
    private val repository = Repository()
    private var _currentCurrencyResult =
        MutableLiveData<PresentExchangeRates>().apply { value = null }
    val currentCurrencyResult: LiveData<PresentExchangeRates> = _currentCurrencyResult

    fun fetchData() {
        repository.getData(object : CallBack<PresentExchangeRates> {
            override fun onResult(value: PresentExchangeRates) {
                _currentCurrencyResult.value = value
            }
        })
    }
}