package com.dekola.dekk22.data.repository

import com.dekola.dekk22.data.model.ProductPresentation
import com.dekola.dekk22.data.remoteDataSource.Result

interface IProductRepository {

    suspend fun getProducts(): Result<List<ProductPresentation?>>
}
