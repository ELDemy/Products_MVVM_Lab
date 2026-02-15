package com.dmy.productswithviewmodel.data.data_source.local

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import com.dmy.productswithviewmodel.data.model.Product

class ProductsLocalDataSourceImpl(context: Context) {
    private val productDao by lazy { AppDatabase.Companion.getInstance(context).productDao() }

    companion object {
        private const val TAG = "ProductsLocalDataSource"
    }

    suspend fun insertProducts(products: List<Product>) {
        productDao.insertAll(products)
        return
    }

    suspend fun updateFavoriteState(product: Product) {
        productDao.updateFavoriteState(product.id)
        return
    }

    suspend fun getProductById(id: Int): Product? {
        return productDao.getProductById(id)
    }


    fun getProducts(): LiveData<List<Product>> {
        Log.i(TAG, "getting products: ")
        return productDao.getAll()
    }


    fun getFavProducts(): LiveData<List<Product>> {
        Log.i(TAG, "getting products: ")
        return productDao.getFavProducts()
    }
}