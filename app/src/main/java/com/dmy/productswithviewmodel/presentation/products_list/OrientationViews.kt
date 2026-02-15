package com.dmy.productswithviewmodel.presentation.products_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dmy.productswithviewmodel.data.model.Product
import com.dmy.productswithviewmodel.presentation.product_details_screen.ProductDetailScreen


@Composable
fun PortraitView(
    modifier: Modifier = Modifier,
    products: List<Product>,
    isLoading: Boolean,
    errorText: String?,
    onProductClick: (Product) -> Unit,
    onToggleFavorite: (Product) -> Unit
) {
    ProductsContent(
        modifier = modifier,
        products = products,
        isLoading = isLoading,
        errorText = errorText,
        onProductClick = onProductClick,
        onToggleFavorite = onToggleFavorite
    )
}


@Composable
fun LandscapeView(
    modifier: Modifier = Modifier,
    products: List<Product>,
    isLoading: Boolean,
    errorText: String?,
    selectedProduct: Product?,
    onProductSelected: (Product) -> Unit,
    onToggleFavorite: (Product) -> Unit
) {
    Row(modifier = modifier) {

        ProductsContent(

            modifier = Modifier.weight(1f),
            products = products,
            isLoading = isLoading,
            errorText = errorText,
            onProductClick = { onProductSelected(it) },
            onToggleFavorite = onToggleFavorite
        )

        VerticalDivider(
            thickness = 1.dp,
            color = MaterialTheme.colorScheme.outlineVariant
        )

        Box(modifier = Modifier.weight(2f)) {
            ProductDetailScreen(selectedProduct?.id)
        }
    }
}