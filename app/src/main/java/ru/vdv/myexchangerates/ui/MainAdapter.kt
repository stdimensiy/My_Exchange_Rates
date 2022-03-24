package ru.vdv.myexchangerates.ui

import android.util.Log
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
        Log.d("Моя проверка", "Всего элементов: ${items.size}")
        Log.d("Моя проверка", "Получен элемент numCode: ${item.charCode}")
        holder.title.text = item.charCode
        holder.description.text = item.name
        holder.currentRate.text = item.value.toString()
        holder.previousRate.text = item.previous.toString()
        holder.duff.text = (item.previous!! - item.value!!).toString()
    }

    override fun getItemCount(): Int {
        return items.size
    }
}