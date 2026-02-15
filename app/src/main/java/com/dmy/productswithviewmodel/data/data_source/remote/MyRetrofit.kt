package com.dmy.productswithviewmodel.data.data_source.remote

import com.dmy.productswithviewmodel.data.model.Product
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class MyRetrofit {
    companion object {
        const val API = "https://dummyjson.com/"
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(API)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val instance = MyRetrofit()
    }


    var productsService: ProductsService = retrofit.create(ProductsService::class.java)
}

interface ProductsService {
    @GET("products")
    suspend fun getProducts(): ProductsResponse?
}

data class ProductsResponse(val products: List<Product>)