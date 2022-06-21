package com.dekola.dekk22.di

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
    fun provideProductRepository(productRemoteDataSource: IProductRemoteDataSource): IProductRepository =
        ProductRepository(productRemoteDataSource)

    @Singleton
    @Provides
    fun provideProductRemoteDataSource(productApiService: ProductApiService): IProductRemoteDataSource =
        ProductRemoteDataSource(productApiService)
}