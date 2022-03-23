package ru.vdv.myexchangerates.domain

interface CallBack<T> {
    fun onResult(value: T)
}