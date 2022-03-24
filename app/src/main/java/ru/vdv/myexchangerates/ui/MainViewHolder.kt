package ru.vdv.myexchangerates.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.vdv.myexchangerates.databinding.ItemCurrencyViewHolderBinding
import ru.vdv.myexchangerates.ui.common.UiConstant

class MainViewHolder(
    li: LayoutInflater,
    parent: ViewGroup,
    binding: ItemCurrencyViewHolderBinding = ItemCurrencyViewHolderBinding.inflate(
        li,
        parent,
        false
    )
) : RecyclerView.ViewHolder(binding.root) {
    val title = binding.title
    val currentRate = binding.currentRate
    val previousRate = binding.previousRate
    val duff = binding.duff
    private val flag = binding.flag
    val status = binding.status
    val nominal = binding.nominal
    val description = binding.description

    fun setFlagForCharCode(charCode: String){
        when (charCode){
            "AMD" -> flag.setImageResource(UiConstant.AMD)
            "AUD" -> flag.setImageResource(UiConstant.AUD)
            "AZN" -> flag.setImageResource(UiConstant.AZN)
            "BGN" -> flag.setImageResource(UiConstant.BGN)
            "BRL" -> flag.setImageResource(UiConstant.BRL)
            "BYN" -> flag.setImageResource(UiConstant.BYN)
            "CAD" -> flag.setImageResource(UiConstant.CAD)
            "CHF" -> flag.setImageResource(UiConstant.CHF)
            "CNY" -> flag.setImageResource(UiConstant.CNY)
            "CZK" -> flag.setImageResource(UiConstant.CZK)
            "DKK" -> flag.setImageResource(UiConstant.DKK)
            "EUR" -> flag.setImageResource(UiConstant.EUR)
            "GBP" -> flag.setImageResource(UiConstant.GBP)
            "HKD" -> flag.setImageResource(UiConstant.HKD)
            "HUF" -> flag.setImageResource(UiConstant.HUF)
            "INR" -> flag.setImageResource(UiConstant.INR)
            "JPY" -> flag.setImageResource(UiConstant.JPY)
            "KGS" -> flag.setImageResource(UiConstant.KGS)
            "KRW" -> flag.setImageResource(UiConstant.KRW)
            "KZT" -> flag.setImageResource(UiConstant.KZT)
            "MDL" -> flag.setImageResource(UiConstant.MDL)
            "NOK" -> flag.setImageResource(UiConstant.NOK)
            "PLN" -> flag.setImageResource(UiConstant.PLN)
            "RON" -> flag.setImageResource(UiConstant.RON)
            "SEK" -> flag.setImageResource(UiConstant.SEK)
            "SGD" -> flag.setImageResource(UiConstant.SGD)
            "TJS" -> flag.setImageResource(UiConstant.TJS)
            "TMT" -> flag.setImageResource(UiConstant.TMT)
            "TRY" -> flag.setImageResource(UiConstant.TRY)
            "UAH" -> flag.setImageResource(UiConstant.UAH)
            "USD" -> flag.setImageResource(UiConstant.USD)
            "UZS" -> flag.setImageResource(UiConstant.UZS)
            "XDR" -> flag.setImageResource(UiConstant.XDR)
            "ZAR" -> flag.setImageResource(UiConstant.ZAR)
        }
    }
}