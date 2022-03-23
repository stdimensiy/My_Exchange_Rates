package ru.vdv.myexchangerates.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.vdv.myexchangerates.domain.valutes.Currency

class MainAdapter : RecyclerView.Adapter<MainViewHolder>() {
    var items: List<Currency> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(LayoutInflater.from(parent.context), parent)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val item = items[position]
        holder.title.text = item.charCode
    }

    override fun getItemCount(): Int {
        return items.size
    }
}