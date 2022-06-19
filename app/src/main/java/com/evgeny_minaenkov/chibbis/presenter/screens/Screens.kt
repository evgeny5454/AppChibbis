package com.evgeny_minaenkov.chibbis.presenter.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.evgeny_minaenkov.chibbis.presenter.NavItem
import com.evgeny_minaenkov.chibbis.presenter.view_models.MainViewModel

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun Screens(navHostController: NavHostController, mainViewModel: MainViewModel, bottomPadding: Dp){
    NavHost(navController = navHostController, startDestination = NavItem.Restaurants.route) {
        composable(NavItem.Restaurants.route) {
            RestaurantsScreen(mainViewModel = mainViewModel, bottomPadding = bottomPadding )
        }
        composable(NavItem.Hits.route) {
            HitsScreen(mainViewModel = mainViewModel, bottomPadding = bottomPadding)
        }
        composable(NavItem.Reviews.route) {
            ReviewsScreen(mainViewModel = mainViewModel, bottomPadding = bottomPadding)
        }
    }
}