package com.dmy.productswithviewmodel.presentation.my_app

import kotlinx.serialization.Serializable


sealed class Screens {
    @Serializable
    object HomeScreen : Screens()

    @Serializable
    object AllProductsScreen : Screens()

    @Serializable
    object FavProductsScreen : Screens()

    @Serializable
    data class ProductDetailScreen(val id: Int) : Screens()
}