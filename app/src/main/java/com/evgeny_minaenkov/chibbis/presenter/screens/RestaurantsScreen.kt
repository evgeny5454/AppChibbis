package com.evgeny_minaenkov.chibbis.presenter.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.evgeny_minaenkov.chibbis.data.model.restaurats.RestaurantsResponseItem
import com.evgeny_minaenkov.chibbis.presenter.view_models.MainViewModel
import com.evgeny_minaenkov.chibbis.presenter.app_views.ItemRestaurant
import com.evgeny_minaenkov.chibbis.presenter.app_views.SearchView

@Composable
fun RestaurantsScreen(mainViewModel: MainViewModel, bottomPadding: Dp) {
    val textState = remember {
        mutableStateOf(TextFieldValue(""))
    }
    val restaurants by mainViewModel.restaurants.observeAsState(emptyList())
    Scaffold(topBar = { SearchView(state = textState, OnClick = { textState.value = it }) }) {
        Column(modifier = Modifier.padding(bottom = bottomPadding)) {
            if (textState.value == TextFieldValue("")) {
                LazyColumn(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    items(restaurants) { item ->
                        ItemRestaurant(item = item)
                    }
                }
            } else {
                val searchRestaurantsList = mutableListOf<RestaurantsResponseItem>()
                restaurants.forEach { item ->
                    if (item.Name.lowercase().contains(textState.value.text.lowercase())) {
                        searchRestaurantsList.add(item)
                    }
                }
                if (searchRestaurantsList.isNotEmpty()){
                    LazyColumn(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        items(searchRestaurantsList) { item ->
                            ItemRestaurant(item = item)
                        }
                    }
                } else {
                    Column(modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.White)
                        .wrapContentSize(Alignment.Center)
                    ) {
                        Text(
                            text = "Ничего не найдено",
                            fontWeight = FontWeight.Normal,
                            color = Color.Black,
                            modifier = Modifier.align(Alignment.CenterHorizontally),
                            textAlign = TextAlign.Center,
                            fontSize = 25.sp
                        )
                    }
                }
            }
        }
    }
}