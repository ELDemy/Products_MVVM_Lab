package com.dmy.productswithviewmodel.presentation.fav_products

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class FavProductsViewModelFactory(
    private val context: Context
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return FavoriteProductsViewModel(context) as T
    }
}
