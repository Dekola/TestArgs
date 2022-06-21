package com.dekola.dekk22.data.repository

import com.dekola.dekk22.data.model.ProductPresentation
import com.dekola.dekk22.data.remoteDataSource.IProductRemoteDataSource
import com.dekola.dekk22.data.remoteDataSource.Result
import javax.inject.Inject

class ProductRepository @Inject constructor(private val productRemoteDataSource: IProductRemoteDataSource) :
    IProductRepository {

    override suspend fun getProducts(): Result<List<ProductPresentation?>> {
        return productRemoteDataSource.getProducts()
    }

}