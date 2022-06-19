package com.evgeny_minaenkov.chibbis.presenter.app_views

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.evgeny_minaenkov.chibbis.R
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun ImageView(
    imageUri: String,
    size: Dp
) {
    Card(
        modifier = Modifier.size(size),
        shape = RoundedCornerShape(4.dp),
        elevation = 0.dp,
        border = BorderStroke(0.5.dp, color = Color.LightGray)
    ) {
        GlideImage(
            imageModel = imageUri,
            contentScale = ContentScale.Crop,
            placeHolder = ImageBitmap.imageResource(id = R.drawable.no_photo),
            error = ImageBitmap.imageResource(id = R.drawable.no_photo)
        )
    }
}