package com.dekola.dekk22.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.dekola.dekk22.data.remoteDataSource.Result
import com.dekola.dekk22.data.repository.ProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.cancel
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.*
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
class ProductViewModelTest {

    @Rule
    @JvmField
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    lateinit var viewModel: ProductViewModel

    private val testDispatcher = UnconfinedTestDispatcher()

    lateinit var mockAnnotation: AutoCloseable

    @Mock
    lateinit var repository: ProductRepository

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        mockAnnotation = MockitoAnnotations.openMocks(this)
        viewModel = ProductViewModel(repository)
    }

    @Test
    fun `test when repository getProducts() returns Result Error`() = runTest {
        val errorMessage = "sdsdv"
        Mockito.`when`(repository.getProducts()).thenReturn(Result.Error(errorMessage))
        viewModel.getProducts()

        Assert.assertEquals(errorMessage, viewModel.productsResult.value?.errorMessage)

    }

    @After
    fun tearDown() {
        testDispatcher.cancel()
        mockAnnotation.close()
    }

}


//import androidx.arch.core.executor.testing.InstantTaskExecutorRule
//import com.dekola.dekk22.data.model.ProductPresentation
//import com.dekola.dekk22.data.remoteDataSource.Result
//import com.dekola.dekk22.data.repository.ProductRepository
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.ExperimentalCoroutinesApi
//import kotlinx.coroutines.cancel
//import kotlinx.coroutines.test.UnconfinedTestDispatcher
//import kotlinx.coroutines.test.runTest
//import kotlinx.coroutines.test.setMain
//import org.junit.*
//import org.mockito.Mock
//import org.mockito.Mockito
//import org.mockito.MockitoAnnotations
//
//@ExperimentalCoroutinesApi
//class ProductViewModelTest {
//
//    @Rule
//    @JvmField
//    val instantTaskExecutorRule = InstantTaskExecutorRule()
//
//    private val dispatcher = UnconfinedTestDispatcher()
//
//    private lateinit var viewModel: ProductViewModel
//
//    @Mock
//    lateinit var repository: ProductRepository
//
//    lateinit var mockitoAnnotations: AutoCloseable
//
//    @Before
//    fun setUp() {
//        mockitoAnnotations = MockitoAnnotations.openMocks(this)
//        Dispatchers.setMain(dispatcher)
//
//        viewModel = ProductViewModel(repository)
//    }
//
//    @Test
//    fun `when getProducts returns Error Result`() = runTest {
//        val errorMessage = "An error occurred"
//        Mockito.`when`(repository.getProducts()).thenReturn(Result.Error(errorMessage))
//
//        viewModel.getProducts()
//
//        Assert.assertEquals(errorMessage, viewModel.productsResult.value?.errorMessage)
//    }
//
//    @Test
//    fun `when getProducts returns Success Result`() = runTest {
//        val testProductPresentation = emptyList<ProductPresentation>()
//        Mockito.`when`(repository.getProducts()).thenReturn(Result.Success(testProductPresentation))
//
//        viewModel.getProducts()
//
//        assert(viewModel.productsResult.value?.success != null)
//    }
//
//    @After
//    fun tearDown() {
//        mockitoAnnotations.close()
//        dispatcher.cancel()
//    }
//}