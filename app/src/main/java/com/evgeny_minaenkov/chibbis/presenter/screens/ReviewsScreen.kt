package com.evgeny_minaenkov.chibbis.presenter.screens

import android.os.Build
import androidx.annotation.RequiresApi
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
import com.evgeny_minaenkov.chibbis.presenter.app_views.ItemReview
import com.evgeny_minaenkov.chibbis.presenter.view_models.MainViewModel

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun ReviewsScreen(mainViewModel: MainViewModel, bottomPadding: Dp) {
    val reviews by mainViewModel.reviews.observeAsState(emptyList())
    Box(
        modifier = Modifier
            .padding(bottom = bottomPadding)
    ) {
        LazyColumn(verticalArrangement = Arrangement.spacedBy(4.dp)) {
            items(reviews) { item ->
                ItemReview(item = item)
            }
        }
    }
}
