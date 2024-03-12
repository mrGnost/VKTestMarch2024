package com.example.vktestmarch2024.repository

import androidx.paging.PagingState
import androidx.paging.rxjava3.RxPagingSource
import com.example.vktestmarch2024.data.api.ProductsApi
import com.example.vktestmarch2024.data.model.ProductResponse
import com.example.vktestmarch2024.data.model.ProductSample
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.HttpException
import java.io.IOException

class ProductPagingSource(
    private val api: ProductsApi
) : RxPagingSource<Int, ProductSample>() {
    override fun loadSingle(params: LoadParams<Int>): Single<LoadResult<Int, ProductSample>> {
        val nextPageNumber = params.key ?: 1
        return api.getProducts((nextPageNumber - 1) * 20, 20)
            .subscribeOn(Schedulers.io())
            .map(this::toLoadResult)
            .onErrorReturn { e ->
                when (e) {
                    is IOException -> LoadResult.Error(e)
                    is HttpException -> LoadResult.Error(e)
                    else -> throw e
                }
            }
    }

    private fun toLoadResult(response: ProductResponse): LoadResult<Int, ProductSample> {
        return LoadResult.Page(
            data = response.products,
            prevKey = null,
            nextKey = response.skip + response.limit
        )
    }

    override fun getRefreshKey(state: PagingState<Int, ProductSample>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}