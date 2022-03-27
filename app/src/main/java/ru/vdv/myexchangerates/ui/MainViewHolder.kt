package ru.vdv.myexchangerates.ui

import android.graphics.Color
import android.graphics.drawable.LayerDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import ru.vdv.myexchangerates.R
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
    val vb = binding.root
    private val flag = binding.flag
    private val status = binding.status
    private val description = binding.description

    fun setFlagForCharCode(charCode: String) {
        when (charCode) {
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

    fun setCurrencyDescription(nominal: Int?, name: String?) {
        name?.let {
            if (nominal != null && (nominal > 1)) {
                "$nominal $name".also { description.text = it }
            } else description.text = it
        }
    }

    fun setCourseChange(value: Double?, previous: Double?) {
        value?.let { current ->
            if (previous != null) {
                val difference = previous - current
                setDuffText(difference)
                if (difference > 0) {
                    setDuffColor(R.color.downwards_course_change)
                    status.setImageResource(R.drawable.ic_change_to_the_smaller_side)
                }
                if (difference < 0) {
                    setDuffColor(R.color.upward_course_change)
                    status.setImageResource(R.drawable.ic_change_in_the_big_way)
                }
                //если значения эквивалентны, тогда на само мделе ничего не делаем,
                //данная ситуация по определению отрабатывается разметкой.

            } else {
                // ситуация когда предыдущего значения курса нет но текущее есть
                // в таком случае разницу не показываем
                // флажок-признак изменения заменяется специальным символом.
                duff.text = ""
                status.setImageResource(R.drawable.ic_change_in_the_big_way)
            }

        }
    }

    private fun setDuffText(difference: Double) {
        duff.text = String.format("%.4f", difference)
    }

    private fun setDuffColor(intColor: Int) {
        duff.setTextColor(
            AppCompatResources.getColorStateList(
                vb.context,
                intColor
            )
        )
    }
}