package com.dmy.productswithviewmodel.presentation.my_app

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.dmy.productswithviewmodel.presentation.all_products.AllProductsScreen
import com.dmy.productswithviewmodel.presentation.fav_products.FavProductsScreen
import com.dmy.productswithviewmodel.presentation.product_details_screen.ProductDetailScreen


@Composable
fun MyApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Screens.HomeScreen
    ) {
        composable<Screens.HomeScreen> {
            HomeScreen(navController)
        }

        composable<Screens.FavProductsScreen> {
            FavProductsScreen(navController)
        }

        composable<Screens.AllProductsScreen> {
            AllProductsScreen(navController)
        }

        composable<Screens.ProductDetailScreen> { backStackEntry ->
            val screen = backStackEntry.toRoute<Screens.ProductDetailScreen>()
            Log.i("Navigation", "backStackEntry with: ${screen.id}")
            ProductDetailScreen(id = screen.id)
        }

    }
}



