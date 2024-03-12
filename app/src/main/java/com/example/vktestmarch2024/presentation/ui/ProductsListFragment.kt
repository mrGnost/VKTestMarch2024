package com.example.vktestmarch2024.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.vktestmarch2024.databinding.FragmentProductListBinding
import com.example.vktestmarch2024.presentation.adapter.ProductsListAdapter
import com.example.vktestmarch2024.presentation.viewmodel.ProductsListViewModel
import com.example.vktestmarch2024.utils.Common
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.rxjava3.disposables.CompositeDisposable

@AndroidEntryPoint
class ProductsListFragment : Fragment() {
    private lateinit var binding: FragmentProductListBinding
    private lateinit var adapter: ProductsListAdapter
    private val viewModel: ProductsListViewModel by viewModels()
    private val disposable = CompositeDisposable()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProductListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        setupPaging()
    }

    private fun setupRecyclerView() {
        adapter = ProductsListAdapter(Common.ProductComparator)
        binding.productsRecycler.adapter = adapter
        binding.productsRecycler.layoutManager = GridLayoutManager(activity, 2)
    }

    private fun setupPaging() {
        disposable.add(viewModel.getProducts().subscribe {
            adapter.submitData(lifecycle, it)
        })
    }
}