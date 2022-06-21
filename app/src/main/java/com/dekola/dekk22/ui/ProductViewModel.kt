package com.dekola.dekk22.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dekola.dekk22.data.model.ProductPresentation
import com.dekola.dekk22.data.remoteDataSource.Result
import com.dekola.dekk22.data.repository.IProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(private val productRepository: IProductRepository) :
    ViewModel() {

    var testMessage: String? = null

    private val _loadLiveData = MutableLiveData<Boolean>()
    val loadLiveData:LiveData<Boolean> = _loadLiveData

    private val _productsResult = MutableLiveData<ProductsResult>()
    val productsResult: LiveData<ProductsResult> = _productsResult

    fun getProducts() {
        viewModelScope.launch {
            _loadLiveData.postValue(true)
            when (val productsResult = productRepository.getProducts()) {
                is Result.Error -> {
                    _productsResult.postValue(ProductsResult(errorMessage = productsResult.errorMessage))
                }
                is Result.Success -> {
                    _productsResult.postValue(ProductsResult(success = productsResult.data))
                }
            }
            _loadLiveData.postValue(false)
        }
    }

    private fun getProductsFlow() {
        viewModelScope.launch {
            _loadLiveData.postValue(true)

            productRepository.getProductsFlow().collect { popularProductsResult->
                when (popularProductsResult) {
                    is Result.Error -> {
                        _productsResult.postValue(ProductsResult(errorMessage = popularProductsResult.errorMessage))
                    }
                    is Result.Success -> {
                        _productsResult.postValue(ProductsResult(success = popularProductsResult.data))
                    }
                }
            }
            _loadLiveData.postValue(false)
        }
    }

    init {
        getProducts()
    }

}

data class ProductsResult(
    val success: List<ProductPresentation?>? = null,
    val errorMessage: String? = null,
)