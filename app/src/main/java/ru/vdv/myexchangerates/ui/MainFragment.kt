package ru.vdv.myexchangerates.ui

import android.annotation.SuppressLint
import android.graphics.drawable.AnimatedVectorDrawable
import android.os.Build
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.LinearLayoutManager
import ru.vdv.myexchangerates.R
import ru.vdv.myexchangerates.databinding.MainFragmentBinding
import java.text.SimpleDateFormat
import java.util.*

class MainFragment : Fragment() {
    private lateinit var adapter: MainAdapter
    private lateinit var reloadButton: ImageView
    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!
    private val avd = { iconRes: Int ->
        AppCompatResources.getDrawable(requireContext(), iconRes) as AnimatedVectorDrawable
    }

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        adapter = MainAdapter()
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        if (savedInstanceState == null) viewModel.fetchData()
        reloadButton = binding.btnReload
        reloadButton.setOnClickListener {
            setBtnStateLoading()
            viewModel.fetchData()
        }
        val currencyList = binding.rvMainList
        currencyList.adapter = adapter
        currencyList.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        viewModel.currentCurrencyResult.observe(viewLifecycleOwner) {
            it?.let {
                it.date?.let { it1 -> setActualDate(it1) }
                it.timestamp?.let { it1 -> setUpdatedDate("российский рубль", it1) }
                adapter.items = it.valute
                adapter.notifyDataSetChanged()
                setBtnStateComplete()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setBtnStateLoading() {
        val icon = avd(R.drawable.ic_cached_rotate_black_24dp_adv)
        reloadButton.setImageDrawable(icon)
        icon.start()
    }

    private fun setBtnStateComplete() {
        val icon = avd(R.drawable.ic_cached_to_read_black_24dp_adv)
        reloadButton.setImageDrawable(icon)
        icon.start()
    }

    private fun setBtnStateDisableLogin() {
        val icon = avd(R.drawable.ic_cached_rotate_black_24dp_adv)
        reloadButton.setImageDrawable(icon)
    }

    @SuppressLint("SimpleDateFormat")
    @RequiresApi(Build.VERSION_CODES.N)
    fun setActualDate(date: String) {
        val date = Date(convertDateToLong(date))
        val titleFormat = SimpleDateFormat(getString(R.string.title_dateFormat_pattern))
        "Курсы валют на ${titleFormat.format(date)}".also {
            binding.mineTitle.text = it
        }
    }

    @SuppressLint("SimpleDateFormat")
    @RequiresApi(Build.VERSION_CODES.N)
    fun setUpdatedDate(baseValute: String, date: String) {
        val updatedDate = Date(convertDateToLong(date))
        val titleFormat = SimpleDateFormat(getString(R.string.description_dateFormat_pattern))
        "Базовая валюта: $baseValute, обновлен ${titleFormat.format(updatedDate)}".also {
            binding.mainDescription.text = it
        }
    }

    @SuppressLint("SimpleDateFormat")
    @RequiresApi(Build.VERSION_CODES.N)
    private fun convertDateToLong(date: String): Long {
        val df = SimpleDateFormat(getString(R.string.resource_dateFormat_pattern))
        return df.parse(date).time
    }
}