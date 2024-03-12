package com.example.vktestmarch2024.data.api

import com.example.vktestmarch2024.data.model.ProductResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductsApi {
    @GET("products")
    fun getProducts(@Query("skip") skip: Int, @Query("limit") limit: Int): Single<ProductResponse>
}