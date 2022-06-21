package com.dekola.dekk22.data.remoteDataSource

import com.dekola.dekk22.data.mapper.toPresentation
import com.dekola.dekk22.data.model.ProductPresentation
import javax.inject.Inject

class ProductRemoteDataSource @Inject constructor(private val productApiService: ProductApiService) :
    IProductRemoteDataSource {

    override suspend fun getProducts(): Result<List<ProductPresentation?>> {
        return try {
            val response = productApiService.getProducts()

            if (response.isSuccessful) {
                response.body()?.objects?.map { it?.toPresentation() }
                    ?.let { productPresentationList ->
                        Result.Success(productPresentationList)
                    } ?: kotlin.run {
                    Result.Error("An error occurred while trying to fetch products")
                }
            } else {
                Result.Error("An error occurred while trying to fetch products")
            }
        } catch (exception: Exception) {
            Result.Error("An error occurred while trying to fetch products")
        }
    }

}