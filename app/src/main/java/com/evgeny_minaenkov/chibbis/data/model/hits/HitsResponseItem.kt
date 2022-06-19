package com.evgeny_minaenkov.chibbis.data.model.hits

data class HitsResponseItem(
    val ProductDescription: String,
    val ProductImage: String,
    val ProductName: String,
    val ProductPrice: Int,
    val RestaurantId: Int,
    val RestaurantLogo: String,
    val RestaurantName: String
)