package com.dmy.productswithviewmodel.presentation.product_details_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage
import com.dmy.productswithviewmodel.data.model.Product


@Composable
fun ProductDetailScreen(id: Int?, modifier: Modifier = Modifier) {

    val productDetailsViewModel =
        viewModel<ProductDetailsViewModel>(
            factory = ProductDetailsViewModelFactory(
                LocalContext.current
            )
        )

    LaunchedEffect(id) {
        productDetailsViewModel.loadProduct(id)
    }

    val product: Product? = productDetailsViewModel.product

    if (product == null) {
        Text(
            "Select a product to view details",
            modifier = modifier.fillMaxSize(),
            textAlign = TextAlign.Center
        )
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
                .verticalScroll(
                    rememberScrollState()
                )
        ) {
            AsyncImage(
                model = product.thumbnail,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
            )
            Spacer(Modifier.height(16.dp))
            Text(text = product.title, fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(8.dp))
            Text(text = product.description, fontSize = 16.sp)
            Spacer(Modifier.height(16.dp))
            DetailRow(label = "Price:", value = product.price.toString())
            DetailRow(label = "Title:", value = product.title)
            DetailRow(label = "Price:", value = product.price.toString())
            DetailRow(label = "Brand:", value = product.brand ?: "N/A")
            DetailRow(label = "Description:", value = product.description)
        }
    }
}

@Composable
fun DetailRow(label: String, value: String) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Text(text = label, fontSize = 16.sp)
        Spacer(Modifier.width(16.dp))
        Text(text = value, fontSize = 14.sp)
        Spacer(Modifier.height(16.dp))
    }
}
