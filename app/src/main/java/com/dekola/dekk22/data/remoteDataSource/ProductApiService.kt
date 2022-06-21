package com.dekola.dekk22.data.remoteDataSource

import com.dekola.dekk22.data.model.ProductsResponse
import retrofit2.Response
import retrofit2.http.GET

interface ProductApiService {

    @GET("products/popular/?offset_id=")
    suspend fun getProducts():Response<ProductsResponse>
}