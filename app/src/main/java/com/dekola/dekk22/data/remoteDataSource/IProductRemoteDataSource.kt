package com.dekola.dekk22.data.remoteDataSource

import com.dekola.dekk22.data.model.ProductPresentation

interface IProductRemoteDataSource {

    suspend fun getProducts(): Result<List<ProductPresentation?>>
}
