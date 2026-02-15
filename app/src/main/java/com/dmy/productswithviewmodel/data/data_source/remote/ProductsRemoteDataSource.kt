package com.dmy.productswithviewmodel.data.data_source.remote

import android.util.Log
import com.dmy.productswithviewmodel.data.model.Product

class ProductsRemoteDataSource {
    companion object {
        val productsService = MyRetrofit.Companion.instance.productsService

        private const val TAG = "ProductsDataSource"
    }

    suspend fun getProducts(): List<Product>? {
        try {
            val products = productsService.getProducts()?.products
            Log.i(TAG, "getProducts: ${products?.size}")
            return products
        } catch (e: Exception) {
            e.printStackTrace()
            return null
        }
    }
    

}