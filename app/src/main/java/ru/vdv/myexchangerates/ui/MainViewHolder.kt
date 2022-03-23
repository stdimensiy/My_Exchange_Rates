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
    var title = binding.title
}