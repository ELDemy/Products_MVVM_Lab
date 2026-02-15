package com.dmy.productswithviewmodel.presentation.fav_products

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.dmy.productswithviewmodel.presentation.products_list.ProductsListScreen


@Composable
fun FavProductsScreen(navController: NavController) {
    val viewModel: FavoriteProductsViewModel =
        viewModel(factory = FavProductsViewModelFactory(LocalContext.current))

    val products by viewModel.products.observeAsState(emptyList())
    ProductsListScreen(
        navController,
        products,
        viewModel.isLoading,
        viewModel.errorText,
        onToggleFavorite = { viewModel.updateFavoriteState(it) }
    )
}
