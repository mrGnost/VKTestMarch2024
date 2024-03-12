package com.example.vktestmarch2024.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.vktestmarch2024.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductsListViewModel
@Inject constructor(private val repository: ProductRepository) : ViewModel() {
    fun getProducts() = repository.getProducts()
}