package com.dmy.productswithviewmodel.data.products_repo

import android.content.Context
import androidx.lifecycle.LiveData
import com.dmy.productswithviewmodel.data.data_source.local.ProductsLocalDataSourceImpl
import com.dmy.productswithviewmodel.data.data_source.remote.ProductsRemoteDataSource
import com.dmy.productswithviewmodel.data.model.Product

class ProductsRepo(context: Context) {

    val localDataSource = ProductsLocalDataSourceImpl(context)
    val remoteDataSource = ProductsRemoteDataSource()

    companion object {
        private const val TAG = "ProductsRepo"
    }

    suspend fun getProducts(): LiveData<List<Product>> {
        remoteDataSource
            .getProducts()
            ?.let { products ->
                localDataSource.insertProducts(products)
            }

        return localDataSource.getProducts()
    }


    fun getFavProducts(): LiveData<List<Product>> {
        return localDataSource.getFavProducts()
    }

    suspend fun getProductById(id: Int): Product? {
        return localDataSource.getProductById(id)
    }

    suspend fun updateFavoriteState(product: Product) {
        localDataSource.updateFavoriteState(product)
        return
    }
}