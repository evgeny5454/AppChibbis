package com.evgeny_minaenkov.chibbis.presenter.app_views

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.evgeny_minaenkov.chibbis.R
import com.evgeny_minaenkov.chibbis.data.model.restaurats.RestaurantsResponseItem

@Composable
fun ItemRestaurant(item: RestaurantsResponseItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 4.dp, end = 4.dp),
        shape = RoundedCornerShape(4.dp),
        elevation = 0.dp
    ) {
        Row(
            modifier = Modifier.padding(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ImageView(imageUri = item.Logo, size = 100.dp)
            Column(modifier = Modifier.padding(start = 4.dp)) {
                Text(
                    text = item.Name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
                Row(modifier = Modifier.padding(top = 10.dp)) {
                    item.Specializations.forEach {
                        Text(
                            text = it.Name + " / "
                        )
                    }
                }
                Row(
                    modifier = Modifier.padding(top = 5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    InfoItem(
                        icon = R.drawable.ic_like,
                        info = item.PositiveReviews.toString() + "%"
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    InfoItem(
                        icon = R.drawable.ic_timer,
                        info = item.DeliveryTime.toString() + "мин."
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    InfoItem(
                        icon = R.drawable.ic_check,
                        info = item.MinCost.toString() + "₽"
                    )
                }
            }
        }

    }
}