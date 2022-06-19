package com.evgeny_minaenkov.chibbis.presenter.app_views

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.evgeny_minaenkov.chibbis.R
import com.evgeny_minaenkov.chibbis.data.model.reviews.ReviewsResponseItem
import com.evgeny_minaenkov.chibbis.utils.DateFormatter

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun ItemReview(item: ReviewsResponseItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 4.dp, end = 4.dp),
        shape = RoundedCornerShape(4.dp),
        elevation = 0.dp,
        border = BorderStroke(0.5.dp, color = Color.LightGray)
    ) {
        Column(modifier = Modifier.padding(start = 8.dp, end = 8.dp)) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = if (item.IsPositive)
                        painterResource(id = R.drawable.ic_like)
                    else
                        painterResource(id = R.drawable.ic_dis_like),
                    contentDescription = "review",
                    tint = if (item.IsPositive) Color.Green else Color.Gray,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = item.UserFIO,
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp
                )
            }

            Column(modifier = Modifier.padding(start = 24.dp)) {
                Text(
                    text = "о ресторане " + item.RestaurantName,
                    fontSize = 14.sp,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = item.Message,
                    fontSize = 17.sp
                )
                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = DateFormatter().formatDate(item.DateAdded),
                    fontSize = 14.sp,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.height(5.dp))
            }
        }
    }
}