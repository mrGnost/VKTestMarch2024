package com.example.vktestmarch2024.data.model

data class ProductResponse(
    val products: List<ProductSample>,
    val total: Int,
    val skip: Int,
    val limit: Int
)
