package com.dmy.productswithviewmodel.presentation.products_list

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.navigation.NavController
import com.dmy.productswithviewmodel.data.model.Product
import com.dmy.productswithviewmodel.presentation.my_app.Screens


@Composable
fun ProductsListScreen(
    navController: NavController,
    products: List<Product>,
    isLoading: Boolean,
    errorText: String?,
    onToggleFavorite: (Product) -> Unit
) {
    val configuration = LocalConfiguration.current
    val isLandscape =
        configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

    var selectedProduct by remember { mutableStateOf<Product?>(null) }

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

        if (isLandscape) {
            LandscapeView(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize(),
                products = products,
                isLoading = isLoading,
                errorText = errorText,
                selectedProduct = selectedProduct,
                onProductSelected = { selectedProduct = it },
                onToggleFavorite = onToggleFavorite
            )

        } else {

            PortraitView(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize(),
                products = products,
                isLoading = isLoading,
                errorText = errorText,
                onProductClick = {
                    navController.navigate(
                        Screens.ProductDetailScreen(it.id)
                    )
                },
                onToggleFavorite = onToggleFavorite
            )
        }
    }
}

