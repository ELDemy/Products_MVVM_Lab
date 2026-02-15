package com.dmy.productswithviewmodel.presentation.fav_products

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dmy.productswithviewmodel.data.model.Product
import com.dmy.productswithviewmodel.data.products_repo.ProductsRepo
import kotlinx.coroutines.launch

class FavoriteProductsViewModel(val context: Context) : ViewModel() {
    private val productsRepo = ProductsRepo(context)

    private val _products = MutableLiveData<List<Product>>(emptyList())
    val products: LiveData<List<Product>> = _products

    var isLoading by mutableStateOf(false)
    var isError by mutableStateOf(false)
    var errorText by mutableStateOf<String?>(null)

    init {
        loadProducts()
    }

    companion object {
        private const val TAG = "ProductsViewModel"
    }

    fun loadProducts() {
        isLoading = true
        viewModelScope.launch {
            try {
                val productsResponse: LiveData<List<Product>> = productsRepo.getFavProducts()
                productsResponse.observeForever { productsList ->
                    _products.value = productsList
                    isLoading = false
                }
                return@launch

            } catch (ex: Exception) {
                ex.printStackTrace()
                isLoading = false
                isError = true
                errorText = ex.message

            }
        }

    }

    fun updateFavoriteState(product: Product) {
        viewModelScope.launch {
            Log.i(TAG, "updateFavoriteState: $product")
            productsRepo.updateFavoriteState(product)

            showToast(product)
        }
    }

    private fun showToast(product: Product) {
        val message: String =
            if (!product.isFavorite) "${product.title} added to favorite"
            else "${product.title} removed from favorite"

        Toast.makeText(
            context,
            message,
            Toast.LENGTH_SHORT
        ).show()
    }

}

