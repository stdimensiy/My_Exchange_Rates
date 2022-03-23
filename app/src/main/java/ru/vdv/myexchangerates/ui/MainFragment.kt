package ru.vdv.myexchangerates.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import ru.vdv.myexchangerates.databinding.MainFragmentBinding

class MainFragment : Fragment() {
    private lateinit var adapter: MainAdapter
    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        if (savedInstanceState == null) viewModel.fetchData()
        val currencyList = binding.rvMainList
        currencyList.adapter = adapter
        currencyList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        viewModel.currentCurrencyResult.observe(viewLifecycleOwner) {
            it?.let {
                adapter.items = it.valute
                adapter.notifyDataSetChanged()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}