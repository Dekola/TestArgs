package com.dekola.dekk22.di

import com.dekola.dekk22.data.local.IProductsLocalDataSource
import com.dekola.dekk22.data.local.ProductDao
import com.dekola.dekk22.data.local.ProductsLocalDataSource
import com.dekola.dekk22.data.remoteDataSource.IProductRemoteDataSource
import com.dekola.dekk22.data.remoteDataSource.ProductApiService
import com.dekola.dekk22.data.remoteDataSource.ProductRemoteDataSource
import com.dekola.dekk22.data.repository.IProductRepository
import com.dekola.dekk22.data.repository.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ProductModule {

    @Singleton
    @Provides
    fun provideProductRepository(
        productRemoteDataSource: IProductRemoteDataSource,
        productsLocalDataSource: IProductsLocalDataSource,
    ): IProductRepository =
        ProductRepository(productRemoteDataSource, productsLocalDataSource)

    @Singleton
    @Provides
    fun provideProductRemoteDataSource(productApiService: ProductApiService): IProductRemoteDataSource =
        ProductRemoteDataSource(productApiService)

    @Provides
    fun provideProductsLocalDataSource(
        productDao: ProductDao,
    ): IProductsLocalDataSource = ProductsLocalDataSource(productDao)

}