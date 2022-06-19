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
import com.evgeny_minaenkov.chibbis.data.model.hits.HitsResponseItem

@Composable
fun ItemHit(item: HitsResponseItem) {
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
            ImageView(imageUri = item.ProductImage, size = 100.dp)

            Column(modifier = Modifier.padding(start = 4.dp)) {
                Text(
                    text = item.ProductName,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(text = item.ProductDescription)
                Spacer(modifier = Modifier.height(4.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = item.ProductPrice.toString() + "₽",
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    ImageView(imageUri = item.RestaurantLogo, size = 24.dp)
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = item.RestaurantName)
                }
            }
        }
    }
}