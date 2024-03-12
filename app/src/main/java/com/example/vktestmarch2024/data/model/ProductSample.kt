package com.example.vktestmarch2024.data.model

data class ProductSample(
    val id: Int,
    val title: String,
    val description: String,
    val price: Int,
    val rating: Double,
    val thumbnail: String,
    val images: List<String>
)