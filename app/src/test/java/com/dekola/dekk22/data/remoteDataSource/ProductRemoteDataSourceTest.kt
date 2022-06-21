package com.dekola.dekk22.data.remoteDataSource

import com.dekola.dekk22.data.model.ProductsResponse
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.exceptions.base.MockitoException
import retrofit2.Response

@ExperimentalCoroutinesApi
internal class ProductRemoteDataSourceTest {

    private lateinit var remoteDataSource: ProductRemoteDataSource

    @Mock
    private lateinit var service: ProductApiService

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        remoteDataSource = ProductRemoteDataSource(service)
    }

    @Test
    fun `test when getProducts returns success`() = runTest {
        val testResponse = ProductsResponse(objects = listOf())
        Mockito.`when`(service.getProducts()).thenReturn(Response.success(testResponse))
        val result = remoteDataSource.getProducts()
        assert(result is Result.Success)
    }

    @Test
    fun `test when getProducts returns error`() = runTest {
        Mockito.`when`(service.getProducts()).thenReturn(Response.error(404, "".toResponseBody()))
        val result = remoteDataSource.getProducts()
        assert(result is Result.Error)
    }

    @Test
    fun `test when getProducts throws exception`() = runTest {
        Mockito.`when`(service.getProducts()).thenThrow(MockitoException(""))
        val result = remoteDataSource.getProducts()
        assert(result is Result.Error)
    }

    @After
    fun tearDown() {
    }
}