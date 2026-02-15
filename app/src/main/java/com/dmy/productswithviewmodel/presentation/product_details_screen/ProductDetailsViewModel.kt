package com.dmy.productswithviewmodel.presentation.product_details_screen

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dmy.productswithviewmodel.data.model.Product
import com.dmy.productswithviewmodel.data.products_repo.ProductsRepo
import kotlinx.coroutines.launch

class ProductDetailsViewModel(context: Context) : ViewModel() {
    private val productsRepo = ProductsRepo(context)

    var product by mutableStateOf<Product?>(null)
        private set


    companion object {
        private const val TAG = "ProductDetailsViewModel"
    }

    fun loadProduct(id: Int?) {
        if (id == null) {
            product = null
            return
        }
        viewModelScope.launch {
            product = productsRepo.getProductById(id)
            return@launch
        }

    }


}