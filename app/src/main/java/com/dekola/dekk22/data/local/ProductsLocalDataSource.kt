package com.dekola.dekk22.data.local

import com.dekola.dekk22.data.mapper.toEntity
import com.dekola.dekk22.data.mapper.toPresentation
import com.dekola.dekk22.data.model.ProductPresentation
import javax.inject.Inject

class ProductsLocalDataSource @Inject constructor(private val productDao: ProductDao) :
    IProductsLocalDataSource {

    override suspend fun savePopularProducts(data: List<ProductPresentation?>?) {
        data?.map { it?.toEntity() }?.let { productDao.updatePopularProducts(it) }
    }

    override suspend fun fetchSavedPopularProducts(): List<ProductPresentation?> {
        return productDao.getAllProducts().map { it.toPresentation() }
    }

}