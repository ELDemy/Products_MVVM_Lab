package com.dmy.productswithviewmodel.presentation.my_app

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Button(
            onClick = { navController.navigate(Screens.AllProductsScreen) }
        ) {
            Text("All Products")
        }

        Spacer(Modifier.height(32.dp))

        Button(
            onClick = { navController.navigate(Screens.FavProductsScreen) }
        ) {
            Text("Favorite Products")
        }
    }
}