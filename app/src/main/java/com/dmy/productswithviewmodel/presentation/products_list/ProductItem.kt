package com.dmy.productswithviewmodel.presentation.products_list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.dmy.productswithviewmodel.data.model.Product


@Composable
fun ProductItem(
    product: Product,
    onClick: () -> Unit,
    onToggleFavorite: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        AsyncImage(
            model = product.thumbnail,
            contentDescription = product.title,
            modifier = Modifier
                .height(150.dp)
                .fillMaxWidth()
        )

        Spacer(Modifier.height(8.dp))

        Button(onClick = onToggleFavorite) {
            Icon(
                imageVector =
                    if (product.isFavorite)
                        Icons.Filled.Favorite
                    else
                        Icons.Filled.FavoriteBorder,
                contentDescription = "Toggle Favorite"
            )
        }

        Text(product.title, fontWeight = FontWeight.Medium)
        HorizontalDivider(Modifier.padding(top = 12.dp))
    }
}
