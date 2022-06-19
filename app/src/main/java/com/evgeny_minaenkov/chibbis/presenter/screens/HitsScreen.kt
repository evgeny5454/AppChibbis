package com.evgeny_minaenkov.chibbis.presenter.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.evgeny_minaenkov.chibbis.presenter.app_views.ItemHit
import com.evgeny_minaenkov.chibbis.presenter.view_models.MainViewModel

@Composable
fun HitsScreen(mainViewModel: MainViewModel, bottomPadding: Dp) {
    val hits by mainViewModel.hits.observeAsState(emptyList())
    Box(
        modifier = Modifier
            .padding(bottom = bottomPadding)
    ) {
        LazyColumn(verticalArrangement = Arrangement.spacedBy(4.dp)) {
            items(hits) { item ->
                ItemHit(item = item)
            }
        }
    }
}
