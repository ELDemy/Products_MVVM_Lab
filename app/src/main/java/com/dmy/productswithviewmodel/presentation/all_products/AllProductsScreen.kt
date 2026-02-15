package com.dmy.productswithviewmodel.presentation.all_products

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.dmy.productswithviewmodel.presentation.products_list.ProductsListScreen


@Composable
fun AllProductsScreen(navController: NavController) {
    val viewModel: AllProductsViewModel =
        viewModel(factory = AllProductsViewModelFactory(LocalContext.current))

    val products by viewModel.products.observeAsState(emptyList())
    ProductsListScreen(
        navController,
        products,
        viewModel.isLoading,
        viewModel.errorText,
        onToggleFavorite = { viewModel.updateFavoriteState(it) }
    )
}


