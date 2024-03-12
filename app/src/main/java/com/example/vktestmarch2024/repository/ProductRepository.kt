package com.example.vktestmarch2024.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.rxjava3.flowable
import com.example.vktestmarch2024.data.api.ProductsApi
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val api: ProductsApi
) {
    fun getProducts() = Pager(
        PagingConfig(pageSize = 20)
    ) {
        ProductPagingSource(api)
    }.flowable
}