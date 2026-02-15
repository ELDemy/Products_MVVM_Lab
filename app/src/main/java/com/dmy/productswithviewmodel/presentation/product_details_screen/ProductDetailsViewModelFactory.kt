package com.dmy.productswithviewmodel.presentation.product_details_screen

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class ProductDetailsViewModelFactory(val context: Context) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProductDetailsViewModel(context) as T
    }
}