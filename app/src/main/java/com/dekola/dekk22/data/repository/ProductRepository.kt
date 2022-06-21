package com.dekola.dekk22.data.repository

import com.dekola.dekk22.data.local.IProductsLocalDataSource
import com.dekola.dekk22.data.model.ProductPresentation
import com.dekola.dekk22.data.remoteDataSource.IProductRemoteDataSource
import com.dekola.dekk22.data.remoteDataSource.Result
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val productRemoteDataSource: IProductRemoteDataSource,
    private val productsLocalDataSource: IProductsLocalDataSource,
) :
    IProductRepository {

    override suspend fun getProducts(): Result<List<ProductPresentation?>> {
        return productRemoteDataSource.getProducts()
    }

    override suspend fun getProductsFlow() = flow {
        emit(fetchSavedPopularProducts())
        val productsResult: Result<List<ProductPresentation?>?> = fetchPopularProducts()

        if (productsResult is Result.Success) {
            savePopularProducts(productsResult.data)
        }
        emit(productsResult)
    }

    private suspend fun fetchPopularProducts(): Result<List<ProductPresentation?>?> {
        return productRemoteDataSource.getProducts()
    }

    private suspend fun fetchSavedPopularProducts(): Result<List<ProductPresentation?>?> {
        return Result.Success(productsLocalDataSource.fetchSavedPopularProducts())
    }

    private suspend fun savePopularProducts(data: List<ProductPresentation?>?) {
        productsLocalDataSource.savePopularProducts(data)
    }
}