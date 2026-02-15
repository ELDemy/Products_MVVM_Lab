package com.dmy.productswithviewmodel.presentation.products_list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dmy.productswithviewmodel.data.model.Product


@Composable
fun ProductsContent(
    modifier: Modifier = Modifier,
    products: List<Product>,
    isLoading: Boolean,
    errorText: String?,
    onProductClick: (Product) -> Unit,
    onToggleFavorite: (Product) -> Unit
) {

    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        item {
            Text(
                text = "Products List",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }

        when {
            isLoading -> {
                item { CircularProgressIndicator() }
            }

            errorText != null -> {
                item { Text(errorText) }
            }

            products.isEmpty() -> {
                item { Text("No Products Found") }
            }

            else -> {
                items(products) { product ->
                    ProductItem(
                        product = product,
                        onClick = { onProductClick(product) },
                        onToggleFavorite = { onToggleFavorite(product) }
                    )
                }
            }
        }
    }
}
