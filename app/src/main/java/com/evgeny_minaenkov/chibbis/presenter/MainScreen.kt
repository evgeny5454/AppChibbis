package com.evgeny_minaenkov.chibbis.presenter

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.evgeny_minaenkov.chibbis.presenter.screens.Screens
import com.evgeny_minaenkov.chibbis.presenter.view_models.MainViewModel
import com.evgeny_minaenkov.chibbis.presenter.app_views.BottomNavigationBar

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val mainViewModel: MainViewModel = viewModel()

    Scaffold(bottomBar = { BottomNavigationBar(navController = navController) }) {
        Screens(
            navHostController = navController,
            mainViewModel = mainViewModel,
            bottomPadding = it.calculateBottomPadding()
        )
    }
}