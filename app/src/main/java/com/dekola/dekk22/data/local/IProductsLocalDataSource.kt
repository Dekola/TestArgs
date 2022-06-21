package com.dekola.dekk22.data.local

import com.dekola.dekk22.data.model.ProductPresentation

interface IProductsLocalDataSource {
    suspend fun savePopularProducts(data: List<ProductPresentation?>?)
    suspend fun fetchSavedPopularProducts():List<ProductPresentation?>?
}