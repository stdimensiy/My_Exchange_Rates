package ru.vdv.myexchangerates.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.vdv.myexchangerates.databinding.ItemCurrencyViewHolderBinding

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
    val flag = binding.flag
    val status = binding.status
    val nominal = binding.nominal
    val description = binding.description
}