package ru.vdv.myexchangerates.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.vdv.myexchangerates.domain.Currency

class MainAdapter : RecyclerView.Adapter<MainViewHolder>() {
    var items: List<Currency> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(LayoutInflater.from(parent.context), parent)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val item = items[position]
        item.charCode?.let {
            holder.setFlagForCharCode(it)
            holder.title.text = it
        }
        holder.setCurrencyDescription(item.nominal, item.name)
        holder.setCourseChange(item.value, item.previous)
        holder.currentRate.text = item.value.toString()
        holder.previousRate.text = item.previous.toString()
        holder.duff.text = String.format("%.4f", (item.previous!! - item.value!!))
    }

    override fun getItemCount(): Int {
        return items.size
    }
}